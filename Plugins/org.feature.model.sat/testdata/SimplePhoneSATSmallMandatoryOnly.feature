<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="SimplePhone">
  <root minCardinality="1" maxCardinality="1" name="SmallFeaturePhone">
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures minCardinality="1" maxCardinality="1" name="Message">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="SMS"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
