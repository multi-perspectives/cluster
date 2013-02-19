<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="DocumentManagementModel">
  <constraints language="CSP" expression="not MetaDataSearch or TitleIndex"/>
  <constraints language="CSP" expression="not GeneralSearch or GeneralIndex"/>
  <constraints language="CSP" expression="not ImageOCR or ImageType"/>
  <constraints language="CSP" expression="not PDFOCR or PDFType"/>
  <constraints language="CSP" expression="not AuthorSearch or AuthorIndex"/>
  <constraints language="CSP" expression="(TextType and not UnicodeTextType) or (not TextType and UnicodeTextType)"/>
  <constraints language="CSP" expression="not TitleIndexUsage or TitleIndex"/>
  <constraints language="CSP" expression="not SearchResults or Search"/>
  <constraints language="CSP" expression="not FileNameSearch or FileNameIndex"/>
  <root minCardinality="1" maxCardinality="1" name="DocumentManagement">
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="OCR">
        <groups maxCardinality="2">
          <childFeatures maxCardinality="1" name="PDFOCR"/>
          <childFeatures maxCardinality="1" name="ImageOCR"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="4">
      <childFeatures maxCardinality="1" name="UnicodeTextType"/>
      <childFeatures maxCardinality="1" name="TextType"/>
      <childFeatures maxCardinality="1" name="ImageType"/>
      <childFeatures maxCardinality="1" name="PDFType"/>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="MetaDataIndex">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="TitleIndex"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="ContentIndex"/>
        </groups>
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="AuthorIndex"/>
        </groups>
      </childFeatures>
      <childFeatures maxCardinality="1" name="GeneralIndex"/>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="FileNameIndex"/>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="Search">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="GeneralSearch"/>
          <childFeatures maxCardinality="1" name="MetaDataSearch">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="ContentSearch"/>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="TitleSearch"/>
            </groups>
            <groups maxCardinality="1">
              <childFeatures maxCardinality="1" name="AuthorSearch"/>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="FileNameSearch"/>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="Report">
        <groups minCardinality="1" maxCardinality="2">
          <childFeatures maxCardinality="1" name="SearchResults"/>
          <childFeatures maxCardinality="1" name="TitleIndexUsage"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
