<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="CD OD Semantic Variability">
  <constraints language="CSP" expression="(not AllowObjectsOmittedOD) or AllowLinksOmittedOD" constrainedFeatures="CDODConsistency"/>
  <constraints language="CSP" expression="(not AllowClassesOmittedCD) or (not AllowTypesOmittedOD)" constrainedFeatures="CDODConsistency"/>
  <constraints language="CSP" expression="EmptyOMValidInstanceOD or (not EmptyOMValidInstanceCD)" constrainedFeatures="CDODConsistency"/>
  <constraints language="CSP" expression="EmptyOMValidInstanceCD or (not EmptyOMValidInstanceOD)" constrainedFeatures="CDODConsistency"/>
  <root minCardinality="1" maxCardinality="1" name="CDODConsistency" constraints="//@constraints.0 //@constraints.1 //@constraints.2 //@constraints.3">
    <attributes name="id" type="String" value="CDODConsistency"/>
    <attributes name="description" type="String" value="Semantic variability for CD OD consistency"/>
    <attributes name="creator" type="String" value="Shahar Maoz, Jan O. Ringert"/>
    <attributes name="address" type="String" value=""/>
    <attributes name="email" type="String" value="--"/>
    <attributes name="phone" type="String" value=""/>
    <attributes name="website" type="String" value="http://www.se-rwth.de/materials/semvar/"/>
    <attributes name="organization" type="String" value="RWTH Aachen"/>
    <attributes name="department" type="String" value="Software Engineering"/>
    <attributes name="date" type="String" value="April 2011"/>
    <attributes name="reference" type="String" value=""/>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="ODSemantics">
        <attributes name="id" type="String" value="ODSemantics"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="EmptyOMOD">
            <attributes name="id" type="String" value="EmptyOMOD"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="EmptyOMValidInstanceOD">
                <attributes name="id" type="String" value="EmptyOMValidInstanceOD"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="EmptyOMInvalidOD">
                <attributes name="id" type="String" value="EmptyOMInvalidOD"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="CompletenessOD">
            <attributes name="id" type="String" value="CompletenessOD"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="ObjectsOD">
                <attributes name="id" type="String" value="ObjectsOD"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="AllObjectsShownOD">
                    <attributes name="id" type="String" value="AllObjectsShownOD"/>
                  </childFeatures>
                  <childFeatures maxCardinality="1" name="AllowObjectsOmittedOD">
                    <attributes name="id" type="String" value="AllowObjectsOmittedOD"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="LinksOD">
                <attributes name="id" type="String" value="LinksOD"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="AllLinksShownOD">
                    <attributes name="id" type="String" value="AllLinksShownOD"/>
                  </childFeatures>
                  <childFeatures maxCardinality="1" name="AllowLinksOmittedOD">
                    <attributes name="id" type="String" value="AllowLinksOmittedOD"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="AttributesOD">
                <attributes name="id" type="String" value="AttributesOD"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="AllAttributesShownOD">
                    <attributes name="id" type="String" value="AllAttributesShownOD"/>
                  </childFeatures>
                  <childFeatures maxCardinality="1" name="AllowAttributesOmittedOD">
                    <attributes name="id" type="String" value="AllowAttributesOmittedOD"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="TypesOD">
                <attributes name="id" type="String" value="TypesOD"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="AllTypesShownOD">
                    <attributes name="id" type="String" value="AllTypesShownOD"/>
                  </childFeatures>
                  <childFeatures maxCardinality="1" name="AllowTypesOmittedOD">
                    <attributes name="id" type="String" value="AllowTypesOmittedOD"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="ObjectTypingOD">
            <attributes name="id" type="String" value="ObjectTypingOD"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="StrictOD">
                <attributes name="id" type="String" value="StrictOD"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="NonStrictOD">
                <attributes name="id" type="String" value="NonStrictOD"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="CDSemantics">
        <attributes name="id" type="String" value="CDSemantics"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="EmptyOMCD">
            <attributes name="id" type="String" value="EmptyOMCD"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="EmptyOMValidInstanceCD">
                <attributes name="id" type="String" value="EmptyOMValidInstanceCD"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="EmptyOMInvalidCD">
                <attributes name="id" type="String" value="EmptyOMInvalidCD"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="CompletenessCD">
            <attributes name="id" type="String" value="CompletenessCD"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="AttributesCD">
                <attributes name="id" type="String" value="AttributesCD"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="AllAttributesShownCD">
                    <attributes name="id" type="String" value="AllAttributesShownCD"/>
                  </childFeatures>
                  <childFeatures maxCardinality="1" name="AllowAttributesOmittedCD">
                    <attributes name="id" type="String" value="AllowAttributesOmittedCD"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="ClassesCD">
                <attributes name="id" type="String" value="ClassesCD"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="AllClassesShownCD">
                    <attributes name="id" type="String" value="AllClassesShownCD"/>
                  </childFeatures>
                  <childFeatures maxCardinality="1" name="AllowClassesOmittedCD">
                    <attributes name="id" type="String" value="AllowClassesOmittedCD"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
