package org.huyong.my.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.Term;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

/**
 * 构建索引
 *     对索引的增删改
 * @author Administrator
 *
 */
public class Demo3 {
    private String ids[]={"1","2","3"};
    private String citys[]={"qingdao","nanjing","shanghai"};
    private String descs[]={
            "Qingdao is a beautiful city.",
            "Nanjing is a city of culture.",
            "Shanghai is a bustling city."
    };
    private FSDirectory dir;

    /**
     * 每次都生成索引文件
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        dir  = FSDirectory.open(Paths.get("/Users/yonghu/Downloads/lucene/indexDir"));
        IndexWriter indexWriter = getIndexWriter();
        for (int i = 0; i < ids.length; i++) {
            Document doc = new Document();
            doc.add(new StringField("id", ids[i], Field.Store.YES));
            doc.add(new StringField("city", citys[i], Field.Store.YES));
            doc.add(new TextField("desc", descs[i], Field.Store.NO));
            indexWriter.addDocument(doc);
        }
        indexWriter.close();
    }

    /**
     * 获取索引输出流
     * @return
     * @throws Exception
     */
    private IndexWriter getIndexWriter()  throws Exception{
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);
        return new IndexWriter(dir, conf );
    }

    /**
     * 测试写了几个索引文件
     * @throws Exception
     */
    @Test
    public void getWriteDocNum() throws Exception {
        IndexWriter indexWriter = getIndexWriter();
        System.out.println("索引目录下生成"+indexWriter.numDocs()+"个索引文件");
    }

    /**
     * 打上标记，该索引实际并未删除
     * @throws Exception
     */
    @Test
    public void deleteDocBeforeMerge() throws Exception {
        IndexWriter indexWriter = getIndexWriter();
        System.out.println("最大文档数："+indexWriter.maxDoc());
        indexWriter.deleteDocuments(new Term("id", "1"));
        indexWriter.commit();

        System.out.println("最大文档数："+indexWriter.maxDoc());
        System.out.println("实际文档数："+indexWriter.numDocs());
        indexWriter.close();
    }

    /**
     * 对应索引文件已经删除,但是该版本的分词会保留
     * @throws Exception
     */
    @Test
    public void deleteDocAfterMerge() throws Exception {
//        https://blog.csdn.net/asdfsadfasdfsa/article/details/78820030
//        org.apache.lucene.store.LockObtainFailedException: Lock held by this virtual machine:indexWriter是单例的、线程安全的，不允许打开多个。
        IndexWriter indexWriter = getIndexWriter();
        System.out.println("最大文档数："+indexWriter.maxDoc());
        indexWriter.deleteDocuments(new Term("id", "1"));
        indexWriter.forceMergeDeletes(); //强制删除
        indexWriter.commit();

        System.out.println("最大文档数："+indexWriter.maxDoc());
        System.out.println("实际文档数："+indexWriter.numDocs());
        indexWriter.close();
    }

    /**
     * 测试更新索引
     * @throws Exception
     */
    @Test
    public void testUpdate()throws Exception{
        IndexWriter writer=getIndexWriter();
        Document doc=new Document();
        doc.add(new StringField("id", "1", Field.Store.YES));
        doc.add(new StringField("city","qingdao",Field.Store.YES));
        doc.add(new TextField("desc", "dsss is a city.", Field.Store.NO));
        writer.updateDocument(new Term("id","1"), doc);
        writer.close();
    }
}