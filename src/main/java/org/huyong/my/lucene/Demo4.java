package org.huyong.my.lucene;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.*;
import org.apache.lucene.search.*;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.junit.Before;
import org.junit.Test;

import java.nio.file.Paths;

public class Demo4 {
    private String ids[]={"1","2","3","4"};
    private String authors[]={"Jack","Marry","John","Json"};
    private String positions[]={"accounting","technician","salesperson","boss"};
    private String titles[]={"Java is a good language.","Java is a cross platform language","Java powerful","You should learn java"};
    private String contents[]={
            "If possible, use the same JRE major version at both index and search time.",
            "When upgrading to a different JRE major version, consider re-indexing. ",
            "Different JRE major versions may implement different versions of Unicode,",
            "For example: with Java 1.4, `LetterTokenizer` will split around the character U+02C6,"
    };

    private Directory dir;//索引文件目录

    @Before
    public void setUp()throws Exception {
        dir = FSDirectory.open(Paths.get("/Users/yonghu/Downloads/lucene/demo3/indexDir"));
        IndexWriter writer = getIndexWriter();
        for (int i = 0; i < authors.length; i++) {
            Document doc = new Document();
            doc.add(new StringField("id", ids[i], Field.Store.YES));
            doc.add(new StringField("author", authors[i], Field.Store.YES));
            doc.add(new StringField("position", positions[i], Field.Store.YES));

            TextField textField = new TextField("title", titles[i], Field.Store.YES);

//            Json投钱做广告，把排名刷到第一了
            if("boss".equals(positions[i])) {
                textField.setBoost(2f);//设置权重，默认为1
            }

            doc.add(textField);
//            TextField会分词，StringField不会分词
            doc.add(new TextField("content", contents[i], Field.Store.NO));
            writer.addDocument(doc);
        }
        writer.close();

    }

    private IndexWriter getIndexWriter() throws Exception{
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig conf = new IndexWriterConfig(analyzer);
        return new IndexWriter(dir, conf);
    }

    @Test
    public void index() throws Exception{
        IndexReader reader = DirectoryReader.open(dir);
        IndexSearcher searcher = new IndexSearcher(reader);
        String fieldName = "title";
        String keyWord = "java";
        Term t = new Term(fieldName, keyWord);
        Query query = new TermQuery(t);
        TopDocs hits = searcher.search(query, 10);
        System.out.println("关键字：‘"+keyWord+"’命中了"+hits.totalHits+"次");
        for (ScoreDoc scoreDoc : hits.scoreDocs) {
            Document doc = searcher.doc(scoreDoc.doc);
            System.out.println(doc.get("author"));
        }
    }

}