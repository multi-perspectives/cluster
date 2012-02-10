<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="DocumentManagementModel">
  <root name="DocumentManagement">
    <groups minCardinality="3" maxCardinality="3">
      <childFeatures minCardinality="1" maxCardinality="1" name="DocumentType">
        <groups maxCardinality="3">
          <childFeatures name="UnicodeTextType"/>
          <childFeatures name="TextType"/>
          <childFeatures name="ImageType"/>
          <childFeatures name="PDFType"/>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="Indexing">
        <groups maxCardinality="1">
          <childFeatures name="MetaDataIndex">
            <groups minCardinality="2" maxCardinality="3">
              <childFeatures minCardinality="1" maxCardinality="1" name="ContentIndex"/>
              <childFeatures minCardinality="1" maxCardinality="1" name="TitelIndex"/>
              <childFeatures name="AuthorIndex"/>
            </groups>
          </childFeatures>
          <childFeatures name="GeneralIndex"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="FileNameIndex"/>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="Search">
        <groups maxCardinality="1">
          <childFeatures name="GeneralSearch"/>
          <childFeatures name="MetaDataSearch">
            <groups minCardinality="2" maxCardinality="3">
              <childFeatures minCardinality="1" maxCardinality="1" name="ContentSearch"/>
              <childFeatures minCardinality="1" maxCardinality="1" name="TitleSearch"/>
              <childFeatures name="AuthorSearch"/>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="FileNameSearch"/>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures name="OCR">
        <groups maxCardinality="2">
          <childFeatures name="PDFOCR"/>
          <childFeatures name="ImageOCR"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
