package org.lncwwn.unicorn.service;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.NIOFSDirectory;
import org.apache.lucene.util.Version;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * A lucence demo
 * Created by victor on 1/5/15.
 */
public class IndexService {

    private static final String PATH = "/home/victor/dev/lucence";

    public static void main( String[] args ) {
        File indexDir = new File( PATH + "/index" );
        Directory fsDir = null;
        File dataDir = new File( PATH + "/data" );
        Analyzer analyzer = new StandardAnalyzer();
        IndexWriterConfig config = new IndexWriterConfig( Version.LATEST, analyzer );
        File[] files = dataDir.listFiles();
        try {
            // may cause bootleneck in multiple threads environment
//            fsDir = new SimpleFSDirectory( indexDir );
            fsDir = new NIOFSDirectory( indexDir );
            IndexWriter indexWriter = new IndexWriter( fsDir, config );

            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    Reader reader = new FileReader( files[i] );
                    Document doc = new Document();
                    doc.add( new Field( "demo", reader ) );
                    indexWriter.addDocument( doc );
                }
            }
            indexWriter.commit();
            indexWriter.close();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }
}
