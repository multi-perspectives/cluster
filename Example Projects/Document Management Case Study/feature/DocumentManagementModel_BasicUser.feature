<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="DocumentManagementModel">
  <root name="DocumentManagement">
    <groups minCardinality="3" maxCardinality="3">
      <childFeatures minCardinality="1" maxCardinality="1" name="DocumentType">
        <groups maxCardinality="2">
          <childFeatures name="TextType"/>
          <childFeatures name="ImageType"/>
          <childFeatures name="PDFType"/>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="Indexing">
        <groups>
          <childFeatures name="GeneralIndex"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="FileNameIndex"/>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="Search">
        <groups>
          <childFeatures name="GeneralSearch"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="FileNameSearch"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
