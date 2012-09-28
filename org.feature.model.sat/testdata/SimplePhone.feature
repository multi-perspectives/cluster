<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="SimplePhone">
  <constraints language="CSP" expression="(not (MMS and not Camera))" constrainedFeatures="MMS Camera"/>
  <constraints language="CSP" expression="(MMS and not M_8) or (not MMS and M_8)" constrainedFeatures="MMS M_8"/>
  <root minCardinality="1" maxCardinality="1" name="SmallFeaturePhone">
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures minCardinality="1" maxCardinality="1" name="Message">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="SMS"/>
        </groups>
        <groups maxCardinality="100">
          <childFeatures maxCardinality="1" name="MMS" constraints="//@constraints.0 //@constraints.1"/>
        </groups>
      </childFeatures>
    </groups>
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
  </root>
</feature:FeatureModel>
