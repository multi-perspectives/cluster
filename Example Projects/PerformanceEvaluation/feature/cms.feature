<?xml version="1.0" encoding="UTF-8"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="CrisisManagementSystem">
  <root minCardinality="1" maxCardinality="1" name="CrisisManagementSystem">
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures minCardinality="1" maxCardinality="1" name="LongDistanceCall">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="PDA"/>
          <childFeatures maxCardinality="1" name="GSM"/>
          <childFeatures maxCardinality="1" name="WalkieTalkie"/>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="InternalResource">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="HumanResource">
            <groups>
              <childFeatures minCardinality="1" maxCardinality="1" name="SystemAdmin"/>
              <childFeatures minCardinality="1" maxCardinality="1" name="Coordinator">
                <groups>
                  <childFeatures maxCardinality="1" name="MultiCoordinators"/>
                </groups>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Observer"/>
              <childFeatures minCardinality="1" maxCardinality="1" name="Worker">
                <groups>
                  <childFeatures minCardinality="1" maxCardinality="1" name="FAWorker"/>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="FirstAidMaterial"/>
        </groups>
      </childFeatures>
      <childFeatures maxCardinality="1" name="Mission">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Pumping"/>
          <childFeatures maxCardinality="1" name="RemoveObstacle"/>
          <childFeatures maxCardinality="1" name="Rescue"/>
          <childFeatures maxCardinality="1" name="Observe"/>
          <childFeatures maxCardinality="1" name="Transport"/>
          <childFeatures maxCardinality="1" name="Investigate"/>
          <childFeatures maxCardinality="1" name="NurseTheWounded"/>
          <childFeatures maxCardinality="1" name="SortTheWounded"/>
          <childFeatures maxCardinality="1" name="Repair">
            <groups maxCardinality="1">
              <childFeatures maxCardinality="1" name="ElectricLine"/>
              <childFeatures maxCardinality="1" name="TelecommunicationsLine"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures maxCardinality="1" name="ITOption">
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="SecureCommunication"/>
          <childFeatures maxCardinality="1" name="SurveillanceSystem"/>
          <childFeatures maxCardinality="1" name="AuthenticationSystem"/>
          <childFeatures maxCardinality="1" name="DatabaseSystem"/>
          <childFeatures maxCardinality="1" name="BackupSystem">
            <groups maxCardinality="-1">
              <childFeatures maxCardinality="1" name="DataMirror"/>
              <childFeatures maxCardinality="1" name="InstantSwitchOver"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="ExternalServicesUsed">
        <groups>
          <childFeatures minCardinality="1" maxCardinality="1" name="GovermentalServices">
            <groups maxCardinality="1">
              <childFeatures maxCardinality="1" name="Army">
                <groups>
                  <childFeatures maxCardinality="1" name="Navy"/>
                  <childFeatures maxCardinality="1" name="TheArmy"/>
                  <childFeatures maxCardinality="1" name="AirForce"/>
                </groups>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Police">
                <groups>
                  <childFeatures minCardinality="1" maxCardinality="1" name="Policemen"/>
                  <childFeatures maxCardinality="1" name="PoliceSpecialUnit"/>
                </groups>
              </childFeatures>
              <childFeatures maxCardinality="1" name="FireDepartment">
                <groups>
                  <childFeatures minCardinality="1" maxCardinality="1" name="Firemen"/>
                  <childFeatures maxCardinality="1" name="Firetruck"/>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="MedicalServices">
            <groups>
              <childFeatures maxCardinality="1" name="PublicHospital"/>
              <childFeatures maxCardinality="1" name="PrivateHospital"/>
              <childFeatures maxCardinality="1" name="IndependentFirstAidDoctor"/>
              <childFeatures maxCardinality="1" name="PrivateAmbulanceCompany"/>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="ExternalCompany">
            <groups>
              <childFeatures maxCardinality="1" name="Electricity"/>
              <childFeatures maxCardinality="1" name="Telecomm"/>
              <childFeatures maxCardinality="1" name="GarageTowTruck"/>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="Area">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Small"/>
          <childFeatures maxCardinality="1" name="Medium"/>
          <childFeatures maxCardinality="1" name="Large"/>
        </groups>
      </childFeatures>
      <childFeatures maxCardinality="1" name="HumanVictims"/>
      <childFeatures maxCardinality="1" name="Witness"/>
      <childFeatures minCardinality="1" maxCardinality="1" name="CrisisTypes">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures minCardinality="1" maxCardinality="1" name="SuddenCrisis">
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="PlantExplosion">
                <groups>
                  <childFeatures maxCardinality="1" name="NuclearPlantExplosion"/>
                  <childFeatures maxCardinality="1" name="TraditionalPlantExplosion"/>
                  <childFeatures maxCardinality="1" name="ChemicalPlantExplosion"/>
                </groups>
              </childFeatures>
              <childFeatures maxCardinality="1" name="NaturalDisasters">
                <groups>
                  <childFeatures maxCardinality="1" name="Flood"/>
                  <childFeatures maxCardinality="1" name="Earthquake"/>
                  <childFeatures maxCardinality="1" name="Fire"/>
                  <childFeatures maxCardinality="1" name="Storm">
                    <groups>
                      <childFeatures maxCardinality="1" name="Hurricane"/>
                      <childFeatures maxCardinality="1" name="Snowstorm"/>
                    </groups>
                  </childFeatures>
                </groups>
              </childFeatures>
              <childFeatures maxCardinality="1" name="TerroristAttack">
                <groups>
                  <childFeatures maxCardinality="1" name="BombAttack"/>
                  <childFeatures maxCardinality="1" name="ChemicalAttack"/>
                  <childFeatures maxCardinality="1" name="PlaneCrash"/>
                </groups>
              </childFeatures>
              <childFeatures maxCardinality="1" name="MajorAccident">
                <groups>
                  <childFeatures maxCardinality="1" name="CarCrash"/>
                  <childFeatures maxCardinality="1" name="AirPlaneCrash"/>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
      <childFeatures minCardinality="1" maxCardinality="1" name="MeasurementUnit">
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="ImperialSystem"/>
          <childFeatures maxCardinality="1" name="MetricSystem"/>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
