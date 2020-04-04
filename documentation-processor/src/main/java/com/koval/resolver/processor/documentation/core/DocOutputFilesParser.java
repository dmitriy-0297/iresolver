package com.koval.resolver.processor.documentation.core;

import com.koval.resolver.common.api.configuration.bean.processors.DocumentationProcessorConfiguration;
import com.koval.resolver.processor.documentation.bean.DocFile;
import com.koval.resolver.processor.documentation.bean.DocMetadata;

import java.util.List;

//TODO: Split DocOutputFilesParser in multiple classes because it has several very different responsibilities
public class DocOutputFilesParser {
  private DocMetadataParser docMetadataParser;
  private DocFileDataParser docFileDataParser;

  public DocOutputFilesParser(
          DocumentationProcessorConfiguration properties,
          DocFileRepository docFileRepository
  ) {
    this.docMetadataParser = new DocMetadataParser(properties.getDocsMetadataFile(), docFileRepository);
    this.docFileDataParser = new DocFileDataParser(properties.getDocsListFile(), docFileRepository);
  }

  public List<DocFile> parseDocumentationFilesList() {
    return docFileDataParser.parseDocumentationFilesList();
  }


  public List<DocMetadata> parseDocumentationMetadata() {
    return docMetadataParser.parseDocumentationMetadata();
  }
}
