<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="SimplePhone">
  <root minCardinality="1" maxCardinality="1" name="SmallFeaturePhone">
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="Extras">
        <groups minCardinality="1" maxCardinality="2">
          <childFeatures maxCardinality="1" name="MP3"/>
          <childFeatures maxCardinality="1" name="Camera"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
