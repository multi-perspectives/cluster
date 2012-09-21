<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="SimplePhone">
  <root minCardinality="1" maxCardinality="1" name="SmallFeaturePhone">
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures minCardinality="1" maxCardinality="1" name="Message">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="SMS"/>
        </groups>
        <groups maxCardinality="100">
          <childFeatures maxCardinality="1" name="MMS"/>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="Communication">
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="Bluetooth"/>
        </groups>
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="WLAN"/>
        </groups>
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="UMTS"/>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="GSM"/>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="Extras">
        <groups minCardinality="1" maxCardinality="2">
          <childFeatures maxCardinality="1" name="MP3"/>
          <childFeatures maxCardinality="1" name="Camera">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="M_3"/>
              <childFeatures maxCardinality="1" name="M_8"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
