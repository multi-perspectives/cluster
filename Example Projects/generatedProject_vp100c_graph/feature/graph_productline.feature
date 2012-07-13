<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="Graph Product Line">
  <constraints language="CSP" expression="unweighted or (not mstprim)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="(not stronglyc) or (not shortest)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="undirected or (not mstprim)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="directed or (not shortest)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="(not mstprim) or (not mstkruskal)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="unweighted or (not mstkruskal)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="undirected or (not stronglyc)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="(not connected) or (not stronglyc)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="Search or (not connected)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="undirected or (not mstkruskal)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="(not mstkruskal) or (not shortest)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="DFS or (not cycle)" constrainedFeatures="GPL"/>
  <constraints language="CSP" expression="(not mstprim) or (not shortest)" constrainedFeatures="GPL"/>
  <root minCardinality="1" maxCardinality="1" name="GPL" constraints="//@constraints.0 //@constraints.1 //@constraints.2 //@constraints.3 //@constraints.4 //@constraints.5 //@constraints.6 //@constraints.7 //@constraints.8 //@constraints.9 //@constraints.10 //@constraints.11 //@constraints.12">
    <attributes name="id" type="String" value="_r"/>
    <attributes name="description" type="String" value="A simple graph product line"/>
    <attributes name="creator" type="String" value="Don Batory"/>
    <attributes name="address" type="String" value=""/>
    <attributes name="email" type="String" value="batory@cs.utexas.edu"/>
    <attributes name="phone" type="String" value=""/>
    <attributes name="website" type="String" value="http://www.cs.utexas.edu/~dsb/"/>
    <attributes name="organization" type="String" value="University of Texas at Austin"/>
    <attributes name="department" type="String" value=""/>
    <attributes name="date" type="String" value=""/>
    <attributes name="reference" type="String" value="Don S. Batory. Feature models, grammars, and propositional formulas. In Software Product Lines, 9th International Conference, SPLC 2005, Rennes, France, September 26-29, 2005, Proceedings, volume 3714 of Lecture Notes in Computer Science, pages 7-20. Springer, 2005"/>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Gtp">
        <attributes name="id" type="String" value="_r_3"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="directed">
            <attributes name="id" type="String" value="_r_3_4_5"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="undirected">
            <attributes name="id" type="String" value="_r_3_4_6"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="Weight">
        <attributes name="id" type="String" value="_r_10"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="weighted">
            <attributes name="id" type="String" value="_r_10_11_12"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="unweighted">
            <attributes name="id" type="String" value="_r_10_11_13"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups maxCardinality="1">
      <childFeatures maxCardinality="1" name="Search">
        <attributes name="id" type="String" value="_r_15"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="BFS">
            <attributes name="id" type="String" value="_r_15_16_17"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="DFS">
            <attributes name="id" type="String" value="_r_15_16_18"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Algorithms">
        <attributes name="id" type="String" value="_r_19"/>
        <groups minCardinality="1" maxCardinality="-1">
          <childFeatures maxCardinality="1" name="connected">
            <attributes name="id" type="String" value="_r_19_20_22"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="stronglyc">
            <attributes name="id" type="String" value="_r_19_20_23"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="cycle">
            <attributes name="id" type="String" value="_r_19_20_24"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="mstprim">
            <attributes name="id" type="String" value="_r_19_20_25"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="mstkruskal">
            <attributes name="id" type="String" value="_r_19_20_26"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="shortest">
            <attributes name="id" type="String" value="_r_19_20_27"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
