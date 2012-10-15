<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="DocumentManagementModel">
  <root minCardinality="1" maxCardinality="1" name="DocumentManagement">
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="DocumentType">
        <groups maxCardinality="2">
          <childFeatures maxCardinality="1" name="TextType"/>
          <childFeatures maxCardinality="1" name="ImageType"/>
          <childFeatures maxCardinality="1" name="PDFType"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Indexing">
        <groups>
          <childFeatures maxCardinality="1" name="GeneralIndex"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="FileNameIndex"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Search">
        <groups>
          <childFeatures maxCardinality="1" name="GeneralSearch"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="FileNameSearch"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
