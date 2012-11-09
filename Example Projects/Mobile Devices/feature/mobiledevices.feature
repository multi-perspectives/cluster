<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="MobileDevices">
  <constraints language="CSP" expression="BGP or not Wifi_AP"/>
  <constraints language="CSP" expression="BGP or not GSM"/>
  <constraints language="CSP" expression="GPS or not LAR"/>
  <constraints language="CSP" expression="Temperature or not WeatherForecast"/>
  <constraints language="CSP" expression="Pressure or not WeatherForecast"/>
  <constraints language="CSP" expression="GSM or not Cellular"/>
  <constraints language="CSP" expression="(not Wifi_Ad-Hoc) or (not BGP)"/>
  <constraints language="CSP" expression="(not LAR) or (not VoIP)"/>
  <root minCardinality="1" maxCardinality="1" name="MobileDevice">
    <groups minCardinality="2" maxCardinality="2">
      <childFeatures minCardinality="1" maxCardinality="1" name="Connection">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="Ad-Hoc">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures minCardinality="1" maxCardinality="1" name="Wifi_Ad-Hoc"/>
            </groups>
          </childFeatures>
          <childFeatures minCardinality="1" maxCardinality="1" name="Infrastructure">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures minCardinality="1" maxCardinality="1" name="Wifi_AP"/>
              <childFeatures minCardinality="1" maxCardinality="1" name="GSM"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="Routing">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="BGP"/>
          <childFeatures minCardinality="1" maxCardinality="1" name="LAR"/>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="2">
      <childFeatures minCardinality="1" maxCardinality="1" name="Application">
        <groups minCardinality="1" maxCardinality="2">
          <childFeatures minCardinality="1" maxCardinality="1" name="PhoneCall">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures minCardinality="1" maxCardinality="1" name="VoIP"/>
              <childFeatures minCardinality="1" maxCardinality="1" name="Cellular"/>
            </groups>
          </childFeatures>
          <childFeatures minCardinality="1" maxCardinality="1" name="WeatherForecast"/>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="Sensors">
        <groups minCardinality="1" maxCardinality="3">
          <childFeatures minCardinality="1" maxCardinality="1" name="GPS"/>
          <childFeatures minCardinality="1" maxCardinality="1" name="Temperature"/>
          <childFeatures minCardinality="1" maxCardinality="1" name="Pressure"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
