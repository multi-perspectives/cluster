<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="DocumentManagementModel">
  <constraints language="OWL" expression="NOT UnicodeTextType" constrainedFeatures="TextType"/>
  <constraints language="OWL" expression="NOT TextType" constrainedFeatures="UnicodeTextType"/>
  <constraints language="OWL" expression="GeneralIndex" constrainedFeatures="GeneralSearch"/>
  <constraints language="OWL" expression="MetaDataIndex" constrainedFeatures="MetaDataSearch"/>
  <root name="DocumentManagement">
    <groups minCardinality="3" maxCardinality="3">
      <childFeatures minCardinality="1" maxCardinality="1" name="DocumentType">
        <groups maxCardinality="4">
          <childFeatures name="UnicodeTextType" constraints="//@constraints.1"/>
          <childFeatures name="TextType" constraints="//@constraints.0"/>
          <childFeatures name="ImageType"/>
          <childFeatures name="PDFType"/>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="Indexing">
        <groups maxCardinality="1">
          <childFeatures name="MetaDataIndex">
            <groups minCardinality="2" maxCardinality="2">
              <childFeatures minCardinality="1" maxCardinality="1" name="TitleIndex"/>
              <childFeatures minCardinality="1" maxCardinality="1" name="ContentIndex"/>
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
          <childFeatures name="GeneralSearch" constraints="//@constraints.2"/>
          <childFeatures name="MetaDataSearch" constraints="//@constraints.3">
            <groups minCardinality="2" maxCardinality="2">
              <childFeatures minCardinality="1" maxCardinality="1" name="TitleSearch"/>
              <childFeatures minCardinality="1" maxCardinality="1" name="ContentSearch"/>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="FileNameSearch"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
