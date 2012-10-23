<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="HIS">
  <constraints language="CSP" expression="(not water) or sprinkler" constrainedFeatures="his"/>
  <constraints language="CSP" expression="(not pumping) or sump_pump" constrainedFeatures="his"/>
  <constraints language="CSP" expression="(not message) or communication" constrainedFeatures="his"/>
  <constraints language="CSP" expression="(not flood) or moisture_sensor" constrainedFeatures="his"/>
  <root minCardinality="1" maxCardinality="1" name="his" constraints="//@constraints.0 //@constraints.1 //@constraints.2 //@constraints.3">
    <attributes name="id" type="String" value="_id_0"/>
    <attributes name="description" type="String" value="This model describes the features of a possible home integration system."/>
    <attributes name="creator" type="String" value="Kyo Kang"/>
    <attributes name="address" type="String" value=""/>
    <attributes name="email" type="String" value="imran@dcs.gla.ac.uk"/>
    <attributes name="phone" type="String" value=""/>
    <attributes name="website" type="String" value=""/>
    <attributes name="organization" type="String" value="University of Glasgow, UK"/>
    <attributes name="department" type="String" value=""/>
    <attributes name="date" type="String" value=""/>
    <attributes name="reference" type="String" value="Kyo Kang, Jaejoon Lee, and Patrick Donohoe. Feature-oriented product line engineering. Software, IEEE, 19(4):58?65, Jul/Aug 2002."/>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="services">
        <attributes name="id" type="String" value="_id_1"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="security">
            <attributes name="id" type="String" value="_id_2"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="intrusion">
            <attributes name="id" type="String" value="_id_3"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="detection_id_4">
                <attributes name="id" type="String" value="_id_4"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="motion">
                    <attributes name="id" type="String" value="_id_5"/>
                    <groups minCardinality="1" maxCardinality="1">
                      <childFeatures maxCardinality="1" name="monitoring_detecting_id_6">
                        <attributes name="id" type="String" value="_id_6"/>
                        <groups minCardinality="1" maxCardinality="1">
                          <childFeatures maxCardinality="1" name="discrete_value_id_8">
                            <attributes name="id" type="String" value="_id_8"/>
                          </childFeatures>
                          <childFeatures maxCardinality="1" name="continuous_value_id_9">
                            <attributes name="id" type="String" value="_id_9"/>
                          </childFeatures>
                        </groups>
                      </childFeatures>
                    </groups>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="action_id_10">
                <attributes name="id" type="String" value="_id_10"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="door_operation">
                    <attributes name="id" type="String" value="_id_11"/>
                  </childFeatures>
                </groups>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="alarm">
                    <attributes name="id" type="String" value="_id_12"/>
                  </childFeatures>
                </groups>
                <groups maxCardinality="1">
                  <childFeatures maxCardinality="1" name="message">
                    <attributes name="id" type="String" value="message"/>
                    <groups maxCardinality="1">
                      <childFeatures maxCardinality="1" name="data">
                        <attributes name="id" type="String" value="_id_13"/>
                      </childFeatures>
                    </groups>
                    <groups minCardinality="1" maxCardinality="1">
                      <childFeatures maxCardinality="1" name="voice">
                        <attributes name="id" type="String" value="_id_14"/>
                      </childFeatures>
                    </groups>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="fire">
            <attributes name="id" type="String" value="_id_15"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="detection_id_16">
                <attributes name="id" type="String" value="_id_16"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="smoke">
                    <attributes name="id" type="String" value="_id_17"/>
                    <groups minCardinality="1" maxCardinality="1">
                      <childFeatures maxCardinality="1" name="monitoring_detecting_id_18">
                        <attributes name="id" type="String" value="_id_18"/>
                        <groups minCardinality="1" maxCardinality="1">
                          <childFeatures maxCardinality="1" name="discrete_value_id_20">
                            <attributes name="id" type="String" value="_id_20"/>
                          </childFeatures>
                          <childFeatures maxCardinality="1" name="continuous_value_id_21">
                            <attributes name="id" type="String" value="_id_21"/>
                          </childFeatures>
                        </groups>
                      </childFeatures>
                    </groups>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="action_id_22">
                <attributes name="id" type="String" value="_id_22"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="water">
                    <attributes name="id" type="String" value="water"/>
                  </childFeatures>
                </groups>
                <groups maxCardinality="1">
                  <childFeatures maxCardinality="1" name="gas">
                    <attributes name="id" type="String" value="_id_23"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="flood">
            <attributes name="id" type="String" value="flood"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="detection">
                <attributes name="id" type="String" value="_id_24"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="moisture">
                    <attributes name="id" type="String" value="_id_25"/>
                    <groups minCardinality="1" maxCardinality="1">
                      <childFeatures maxCardinality="1" name="monitoring_detecting">
                        <attributes name="id" type="String" value="_id_26"/>
                        <groups minCardinality="1" maxCardinality="1">
                          <childFeatures maxCardinality="1" name="discrete_value">
                            <attributes name="id" type="String" value="_id_28"/>
                          </childFeatures>
                          <childFeatures maxCardinality="1" name="continuous_value">
                            <attributes name="id" type="String" value="_id_29"/>
                          </childFeatures>
                        </groups>
                      </childFeatures>
                    </groups>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="action">
                <attributes name="id" type="String" value="_id_30"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="water_main">
                    <attributes name="id" type="String" value="_id_31"/>
                  </childFeatures>
                </groups>
                <groups maxCardinality="1">
                  <childFeatures maxCardinality="1" name="pumping">
                    <attributes name="id" type="String" value="pumping"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="administration">
        <attributes name="id" type="String" value="_id_32"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="hmi">
            <attributes name="id" type="String" value="_id_33"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="standard">
                <attributes name="id" type="String" value="_id_35"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="advanced">
                <attributes name="id" type="String" value="_id_36"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="communication">
        <attributes name="id" type="String" value="communication"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="telephone">
            <attributes name="id" type="String" value="_id_37"/>
          </childFeatures>
        </groups>
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="internet">
            <attributes name="id" type="String" value="_id_38"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="connection">
                <attributes name="id" type="String" value="_id_39"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="tcp">
                    <attributes name="id" type="String" value="_id_41"/>
                  </childFeatures>
                  <childFeatures maxCardinality="1" name="udp">
                    <attributes name="id" type="String" value="_id_42"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="detection_devices">
        <attributes name="id" type="String" value="_id_43"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="motion_sensor">
            <attributes name="id" type="String" value="_id_44"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="skoke_sensor">
            <attributes name="id" type="String" value="_id_45"/>
          </childFeatures>
        </groups>
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="moisture_sensor">
            <attributes name="id" type="String" value="moisture_sensor"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="action_devices">
        <attributes name="id" type="String" value="_id_46"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="sprinkler">
            <attributes name="id" type="String" value="sprinkler"/>
          </childFeatures>
        </groups>
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="sump_pump">
            <attributes name="id" type="String" value="sump_pump"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="monitor_control">
        <attributes name="id" type="String" value="_id_47"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="direct">
            <attributes name="id" type="String" value="_id_48"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="scheduled">
            <attributes name="id" type="String" value="_id_49"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="periodic">
                <attributes name="id" type="String" value="_id_50"/>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="one_time">
                <attributes name="id" type="String" value="_id_51"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="responding_strategy">
            <attributes name="id" type="String" value="_id_52"/>
            <groups maxCardinality="1">
              <childFeatures maxCardinality="1" name="sequential">
                <attributes name="id" type="String" value="_id_53"/>
              </childFeatures>
            </groups>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="priority">
                <attributes name="id" type="String" value="_id_54"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="event_based">
            <attributes name="id" type="String" value="_id_55"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="quality_attributes">
        <attributes name="id" type="String" value="_id_56"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="usability">
            <attributes name="id" type="String" value="_id_57"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="scalability">
            <attributes name="id" type="String" value="_id_58"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="reliability">
            <attributes name="id" type="String" value="_id_59"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="redundancy_control">
                <attributes name="id" type="String" value="_id_60"/>
                <groups minCardinality="1" maxCardinality="1">
                  <childFeatures maxCardinality="1" name="active">
                    <attributes name="id" type="String" value="_id_62"/>
                  </childFeatures>
                  <childFeatures maxCardinality="1" name="standby">
                    <attributes name="id" type="String" value="_id_63"/>
                  </childFeatures>
                </groups>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="safety">
            <attributes name="id" type="String" value="_id_64"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
