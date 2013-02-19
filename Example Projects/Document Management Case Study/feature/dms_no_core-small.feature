<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="DocumentManagementModel">
  <constraints language="CSP" expression="not MetaDataSearch or MetaDataIndex"/>
  <constraints language="CSP" expression="not GeneralSearch or GeneralIndex"/>
  <constraints language="CSP" expression="(TextType and not UnicodeTextType) or (not TextType and UnicodeTextType)"/>
  <root minCardinality="1" maxCardinality="1" name="DocumentManagement">
    <groups minCardinality="1" maxCardinality="3">
      <childFeatures maxCardinality="1" name="UnicodeTextType"/>
      <childFeatures maxCardinality="1" name="TextType"/>
      <childFeatures maxCardinality="1" name="PDFType"/>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="MetaDataIndex"/>
      <childFeatures maxCardinality="1" name="GeneralIndex"/>
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
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
