<?xml version="1.0" encoding="Cp1252"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="SimplePhone">
  <constraints language="SAT" expression="require(MMS, Camera)" constrainedFeatures="MMS Camera"/>
  <constraints language="SAT" expression="exclude(MMS, M_8)" constrainedFeatures="MMS M_8"/>
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
      <childFeatures maxCardinality="1" name="Extras">
        <groups minCardinality="1" maxCardinality="2">
          <childFeatures maxCardinality="1" name="MP3"/>
          <childFeatures maxCardinality="1" name="Camera" constraints="//@constraints.0">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="M_3"/>
              <childFeatures maxCardinality="1" name="M_8" constraints="//@constraints.1"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="100">
      <childFeatures maxCardinality="1" name="MMS" constraints="//@constraints.0 //@constraints.1"/>
    </groups>
  </root>
</feature:FeatureModel>
