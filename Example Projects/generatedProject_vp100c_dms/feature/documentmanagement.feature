<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="DocumentManagementModel">
  <constraints language="CSP" expression="not MetaDataSearch or MetaDataIndex" constrainedFeatures="DocumentManagement"/>
  <constraints language="CSP" expression="not GeneralSearch or GeneralIndex" constrainedFeatures="DocumentManagement"/>
  <constraints language="CSP" expression="not ImageOCR or ImageType" constrainedFeatures="DocumentManagement"/>
  <constraints language="CSP" expression="not PDFOCR or PDFType" constrainedFeatures="DocumentManagement"/>
  <constraints language="CSP" expression="not AuthorSearch or AuthorIndex" constrainedFeatures="DocumentManagement"/>
  <constraints language="CSP" expression="(TextType and not UnicodeTextType) or (not TextType and UnicodeTextType)" constrainedFeatures="DocumentManagement"/>
  <root minCardinality="1" maxCardinality="1" name="DocumentManagement" constraints="//@constraints.0 //@constraints.1 //@constraints.2 //@constraints.3 //@constraints.4 //@constraints.5">
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="DocumentType">
        <groups maxCardinality="4">
          <childFeatures maxCardinality="1" name="UnicodeTextType"/>
          <childFeatures maxCardinality="1" name="TextType"/>
          <childFeatures maxCardinality="1" name="ImageType"/>
          <childFeatures maxCardinality="1" name="PDFType"/>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures minCardinality="1" maxCardinality="1" name="OCR">
        <groups maxCardinality="2">
          <childFeatures maxCardinality="1" name="PDFOCR"/>
          <childFeatures maxCardinality="1" name="ImageOCR"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Indexing">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="MetaDataIndex">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="TitelIndex"/>
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
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="FileNameIndex"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
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
  </root>
</feature:FeatureModel>
