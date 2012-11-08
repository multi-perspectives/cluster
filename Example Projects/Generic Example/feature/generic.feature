<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature">
  <root minCardinality="1" maxCardinality="1" name="FRoot">
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="F1"/>
      <childFeatures maxCardinality="1" name="F2">
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="F2.1"/>
          <childFeatures maxCardinality="1" name="F2.2"/>
        </groups>
      </childFeatures>
      <childFeatures maxCardinality="1" name="F3">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures name="F3.1"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="F4">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="F4.1"/>
          <childFeatures maxCardinality="1" name="F4.2"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="F5">
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="F5.1"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="F5.2">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="F5.2.1"/>
              <childFeatures maxCardinality="1" name="F5.2.2"/>
              <childFeatures maxCardinality="1" name="F5.2.3"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="F6">
        <groups minCardinality="1" maxCardinality="3">
          <childFeatures maxCardinality="1" name="F6.1"/>
          <childFeatures maxCardinality="1" name="F6.2"/>
          <childFeatures maxCardinality="1" name="F6.3"/>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="F7">
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="F7.1"/>
          <childFeatures maxCardinality="1" name="F7.2"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
