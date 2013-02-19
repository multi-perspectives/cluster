<?xml version="1.0" encoding="Cp1252"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="SimplePhone">
  <root minCardinality="1" maxCardinality="1" name="SmallFeaturePhone">
    <groups maxCardinality="1">
      <childFeatures maxCardinality="100" name="Communication">
        <groups maxCardinality="100">
          <childFeatures maxCardinality="1" name="WLAN"/>
          <childFeatures maxCardinality="1" name="Bluetooth"/>
          <childFeatures maxCardinality="1" name="UMTS"/>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="MP3"/>
    </groups>
  </root>
</feature:FeatureModel>
