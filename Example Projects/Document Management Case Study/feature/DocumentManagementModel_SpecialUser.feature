<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="DocumentManagementModel">
  <root minCardinality="1" maxCardinality="1" name="DocumentManagement">
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="DocumentType">
        <groups maxCardinality="3">
          <childFeatures maxCardinality="1" name="UnicodeTextType"/>
          <childFeatures maxCardinality="1" name="TextType"/>
          <childFeatures maxCardinality="1" name="ImageType"/>
          <childFeatures maxCardinality="1" name="PDFType"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Indexing">
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="MetaDataIndex">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="TitelIndex"/>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="ContentIndex"/>
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
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="GeneralSearch"/>
          <childFeatures maxCardinality="1" name="MetaDataSearch">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="ContentSearch"/>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="TitleSearch"/>
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
