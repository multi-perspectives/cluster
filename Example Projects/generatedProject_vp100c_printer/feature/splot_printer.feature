<?xml version="1.0" encoding="ASCII"?>
<feature:FeatureModel xmi:version="2.0" xmlns:xmi="http://www.omg.org/XMI" xmlns:feature="http://www.tudresden.de/feature" name="Printers">
  <root minCardinality="1" maxCardinality="1" name="Xerox">
    <attributes name="id" type="String" value="_r"/>
    <attributes name="description" type="String" value="feature model"/>
    <attributes name="creator" type="String" value="Priya"/>
    <attributes name="address" type="String" value=""/>
    <attributes name="email" type="String" value="Chantabbai@gmail.com"/>
    <attributes name="phone" type="String" value=""/>
    <attributes name="website" type="String" value=""/>
    <attributes name="organization" type="String" value="TRDDC"/>
    <attributes name="department" type="String" value=""/>
    <attributes name="date" type="String" value=""/>
    <attributes name="reference" type="String" value=""/>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Capabilites">
        <attributes name="id" type="String" value="_r_1"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Standard_Capabilities">
            <attributes name="id" type="String" value="_r_1_17"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Print_r_1_17_18_19">
                <attributes name="id" type="String" value="_r_1_17_18_19"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Scan_r_1_17_18_20">
                <attributes name="id" type="String" value="_r_1_17_18_20"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Copy">
                <attributes name="id" type="String" value="_r_1_17_18_21"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Fax">
                <attributes name="id" type="String" value="_r_1_17_18_22"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Production_Printing">
                <attributes name="id" type="String" value="_r_1_17_18_99"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Finishing_r_1_17_18_100">
                <attributes name="id" type="String" value="_r_1_17_18_100"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Reprinting">
                <attributes name="id" type="String" value="_r_1_17_18_141"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Production_MICR_Printing">
                <attributes name="id" type="String" value="_r_1_17_18_151"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="High-volume_network_printing_and_3rd-party_finishing">
                <attributes name="id" type="String" value="_r_1_17_18_161"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups maxCardinality="1">
          <childFeatures maxCardinality="1" name="Optional_Capabilties">
            <attributes name="id" type="String" value="_r_1_23"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Finishing_r_1_23_24_25">
                <attributes name="id" type="String" value="_r_1_23_24_25"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Scanning">
                <attributes name="id" type="String" value="_r_1_23_24_162"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Printed_Sides">
            <attributes name="id" type="String" value="_r_1_26"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="Duplex">
                <attributes name="id" type="String" value="_r_1_26_28_29"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="MICR">
            <attributes name="id" type="String" value="_r_1_27"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="Yes">
                <attributes name="id" type="String" value="_r_1_27_152_153"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="No">
                <attributes name="id" type="String" value="_r_1_27_152_154"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Product_Color">
            <attributes name="id" type="String" value="_r_1_163"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Print_Line_Management">
            <attributes name="id" type="String" value="_r_1_172"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Performance">
        <attributes name="id" type="String" value="_r_2"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Rated_Speed">
            <attributes name="id" type="String" value="_r_2_11"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Resolution">
            <attributes name="id" type="String" value="_r_2_12"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Print">
                <attributes name="id" type="String" value="_r_2_12_96_97"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="RIP">
                <attributes name="id" type="String" value="_r_2_12_96_98"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Scan">
                <attributes name="id" type="String" value="_r_2_12_96_136"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Scan_to_file">
                <attributes name="id" type="String" value="_r_2_12_96_137"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Black_r_2_12_96_159">
                <attributes name="id" type="String" value="_r_2_12_96_159"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Color_r_2_12_96_160">
                <attributes name="id" type="String" value="_r_2_12_96_160"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Recommended_average_monthly_volume">
            <attributes name="id" type="String" value="_r_2_13"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Duty_cycle">
            <attributes name="id" type="String" value="_r_2_14"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Scan_Speed">
            <attributes name="id" type="String" value="_r_2_15"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Integrated_Scanner">
                <attributes name="id" type="String" value="_r_2_15_138_139"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Free_Flow_Scanner">
                <attributes name="id" type="String" value="_r_2_15_138_140"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Line_Screens">
            <attributes name="id" type="String" value="_r_2_16"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Technology">
        <attributes name="id" type="String" value="_r_3"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="PDLs">
            <attributes name="id" type="String" value="_r_3_30"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Network_Interfaces">
            <attributes name="id" type="String" value="_r_3_31"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Memory">
            <attributes name="id" type="String" value="_r_3_101"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Harddisk">
            <attributes name="id" type="String" value="_r_3_102"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="CPU">
            <attributes name="id" type="String" value="_r_3_103"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="User_Interface">
            <attributes name="id" type="String" value="_r_3_104"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Print_Engine_r_3_164">
            <attributes name="id" type="String" value="_r_3_164"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Process_or_Imaging">
            <attributes name="id" type="String" value="_r_3_165"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Black">
                <attributes name="id" type="String" value="_r_3_165_166_167"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Color">
                <attributes name="id" type="String" value="_r_3_165_166_168"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Paper_Handling">
        <attributes name="id" type="String" value="_r_4"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Paper_sources">
            <attributes name="id" type="String" value="_r_4_32"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Sheet_Feed_Module_r_4_32_166_167">
                <attributes name="id" type="String" value="_r_4_32_166_167"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="High_Capacity_Sheet_Feed_Module_r_4_32_166_168">
                <attributes name="id" type="String" value="_r_4_32_166_168"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="High_Capacity_Stacking_Option_r_4_32_166_169">
                <attributes name="id" type="String" value="_r_4_32_166_169"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Stitching_and_Binding_option_r_4_32_166_170">
                <attributes name="id" type="String" value="_r_4_32_166_170"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Standard_paper_capacity">
            <attributes name="id" type="String" value="_r_4_33"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Sheet_Feed_Module">
                <attributes name="id" type="String" value="_r_4_33_169_170"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="High_Capacity_Sheet_Feed_Module">
                <attributes name="id" type="String" value="_r_4_33_169_171"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="High_Capacity_Stacking_Option">
                <attributes name="id" type="String" value="__r_4_33_169_171"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Stitching_and_Binding_option">
                <attributes name="id" type="String" value="_r_4_33_169_172"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Maximum_paper_capacity_with_options">
            <attributes name="id" type="String" value="_r_4_34"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Media_Dimensions_-_Minimum">
            <attributes name="id" type="String" value="_r_4_35"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Media_Dimensions_-_Maximum">
            <attributes name="id" type="String" value="_r_4_36"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Media_Weight_-_Minimum">
            <attributes name="id" type="String" value="_r_4_37"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="coated_r_4_37_110_111">
                <attributes name="id" type="String" value="_r_4_37_110_111"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="uncoated_r_4_37_110_112">
                <attributes name="id" type="String" value="_r_4_37_110_112"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Media_Weight_-_Maximum">
            <attributes name="id" type="String" value="_r_4_39"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="coated_r_4_39_113_114">
                <attributes name="id" type="String" value="_r_4_39_113_114"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="uncoated_r_4_39_113_115">
                <attributes name="id" type="String" value="_r_4_39_113_115"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Media_Types">
            <attributes name="id" type="String" value="_r_4_40"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="coated">
                <attributes name="id" type="String" value="_r_4_40_106_107"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="uncoated">
                <attributes name="id" type="String" value="_r_4_40_106_108"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="speciality">
                <attributes name="id" type="String" value="_r_4_40_106_109"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Input">
        <attributes name="id" type="String" value="_r_5"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="High_Capacity_Feeder">
            <attributes name="id" type="String" value="_r_5_41"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Standard_Four-tray_Sheet">
                <attributes name="id" type="String" value="_r_5_41_155_156"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Oversized_High-Capacity_Sheet_Feed_Module">
                <attributes name="id" type="String" value="_r_5_41_155_157"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Roll_Feed_Solution">
                <attributes name="id" type="String" value="_r_5_41_155_165"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Other_Input_Devices">
            <attributes name="id" type="String" value="_r_5_42"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Post-print_Four-tray_Paper_Insertion_Module">
                <attributes name="id" type="String" value="_r_5_42_158_159"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Post-print_Oversized_Two-tray_Paper_Insertion_Module">
                <attributes name="id" type="String" value="_r_5_42_158_160"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Insertion_Module">
                <attributes name="id" type="String" value="_r_5_42_158_172"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="High_Capacity_Insertion_Module">
                <attributes name="id" type="String" value="_r_5_42_158_173"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Tray">
            <attributes name="id" type="String" value="_r_5_43"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Tray_1">
                <attributes name="id" type="String" value="_r_5_43_44_45"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Tray_2">
                <attributes name="id" type="String" value="_r_5_43_44_46"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Tray_3">
                <attributes name="id" type="String" value="_r_5_43_44_47"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Tray_4">
                <attributes name="id" type="String" value="_r_5_43_44_48"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Tray_5">
                <attributes name="id" type="String" value="_r_5_43_44_49"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Electronic_Input">
            <attributes name="id" type="String" value="_r_5_142"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Automatic_Doucment_Feeder">
            <attributes name="id" type="String" value="_r_5_143"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Output">
        <attributes name="id" type="String" value="_r_6"/>
        <groups minCardinality="1" maxCardinality="-1">
          <childFeatures maxCardinality="1" name="Offset_Output_Tray">
            <attributes name="id" type="String" value="_r_6_117_118"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Top_Tray">
            <attributes name="id" type="String" value="_r_6_117_119"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Stacker_r_6_117_144">
            <attributes name="id" type="String" value="_r_6_117_144"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Finishing">
        <attributes name="id" type="String" value="_r_7"/>
        <groups minCardinality="1" maxCardinality="-1">
          <childFeatures maxCardinality="1" name="Finisher">
            <attributes name="id" type="String" value="_r_7_51_52"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Basic_Finisher_Module_r_7_51_52_132_133">
                <attributes name="id" type="String" value="_r_7_51_52_132_133"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Basic_Finisher_Module_Plus_r_7_51_52_132_134">
                <attributes name="id" type="String" value="_r_7_51_52_132_134"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Basic_Finisher_Module-DC">
                <attributes name="id" type="String" value="_r_7_51_52_132_135"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Multifunction_Finisher_Professional">
                <attributes name="id" type="String" value="_r_7_51_52_132_146"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Multifunction_Finisher_Pro_plus_r_7_51_52_132_147">
                <attributes name="id" type="String" value="_r_7_51_52_132_147"/>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Booklet_Making">
            <attributes name="id" type="String" value="_r_7_51_53"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Stapler">
            <attributes name="id" type="String" value="_r_7_51_54"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Binder">
            <attributes name="id" type="String" value="_r_7_51_127"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Cutting">
            <attributes name="id" type="String" value="_r_7_51_128"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Tape_Bound">
            <attributes name="id" type="String" value="_r_7_51_129"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Hole_Punch">
            <attributes name="id" type="String" value="_r_7_51_130"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Other_Finishing_Options">
            <attributes name="id" type="String" value="_r_7_51_131"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Stacker">
            <attributes name="id" type="String" value="_r_7_51_145"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Slitter_or_Merger">
            <attributes name="id" type="String" value="_r_7_51_161"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="ByPass_Transport">
            <attributes name="id" type="String" value="_r_7_51_174"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Print_Controllers">
        <attributes name="id" type="String" value="_r_8"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Digital_front-ends">
            <attributes name="id" type="String" value="_r_8_55"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Environmental">
        <attributes name="id" type="String" value="_r_9"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Electrical_Requirements">
            <attributes name="id" type="String" value="_r_9_56"/>
          </childFeatures>
        </groups>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Dimensions">
            <attributes name="id" type="String" value="_r_9_57"/>
            <groups minCardinality="1" maxCardinality="-1">
              <childFeatures maxCardinality="1" name="Print_Engine">
                <attributes name="id" type="String" value="_r_9_57_120_121"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Sheet_feed_and_Insertion_Module">
                <attributes name="id" type="String" value="_r_9_57_120_122"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Sheet_Enhancement_Module">
                <attributes name="id" type="String" value="_r_9_57_120_123"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Basic_Finisher_Module">
                <attributes name="id" type="String" value="_r_9_57_120_124"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Basic_Finisher_Module_Plus">
                <attributes name="id" type="String" value="_r_9_57_120_125"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Finishing_Transport_Module">
                <attributes name="id" type="String" value="_r_9_57_120_126"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Feeder_Module_With_Integrated_Scanner">
                <attributes name="id" type="String" value="_r_9_57_120_148"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Professional">
                <attributes name="id" type="String" value="_r_9_57_120_149"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Multifunction_Finisher_Pro_plus">
                <attributes name="id" type="String" value="_r_9_57_120_150"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Basic_Finisher_Module_DC">
                <attributes name="id" type="String" value="_r_9_57_120_162"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Xerox_DS3500_Stacker">
                <attributes name="id" type="String" value="_r_9_57_120_163"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Xerox_Tape_Binder">
                <attributes name="id" type="String" value="_r_9_57_120_164"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Security">
        <attributes name="id" type="String" value="_r_10"/>
        <groups minCardinality="1" maxCardinality="-1">
          <childFeatures maxCardinality="1" name="IP_filtering">
            <attributes name="id" type="String" value="_r_10_58_59"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Image_overwrite">
            <attributes name="id" type="String" value="_r_10_58_60"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Secure_print">
            <attributes name="id" type="String" value="_r_10_58_61"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Encrypted_Scan_to_email">
            <attributes name="id" type="String" value="_r_10_58_62"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Authentication">
            <attributes name="id" type="String" value="_r_10_58_63"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="IP-v6_support">
            <attributes name="id" type="String" value="_r_10_58_64"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Price">
        <attributes name="id" type="String" value="_r_65"/>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Category">
        <attributes name="id" type="String" value="_r_66"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Digital_Printing_Presses">
            <attributes name="id" type="String" value="_r_66_67_68"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="Color_Digital_Printing_Press">
                <attributes name="id" type="String" value="_r_66_67_68_74_75"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="B_and_W_Publishing_Digital_Printing_Press">
                <attributes name="id" type="String" value="_r_66_67_68_74_76"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="B_and_W_Transaction_Digital_Printing_Press">
                <attributes name="id" type="String" value="_r_66_67_68_74_77"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="HighLight_Color_Digital_Printing_Press">
                <attributes name="id" type="String" value="_r_66_67_68_74_78"/>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Production_Printers_and_Copiers">
            <attributes name="id" type="String" value="_r_66_67_69"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="Color_Printers">
                <attributes name="id" type="String" value="_r_66_67_69_79_80"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="B_and_W_Printers">
                <attributes name="id" type="String" value="_r_66_67_69_79_81"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="B_and_W_Publishing">
                <attributes name="id" type="String" value="_r_66_67_69_79_82"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="B_and_W_Transaction">
                <attributes name="id" type="String" value="_r_66_67_69_79_83"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="HighLight_Color">
                <attributes name="id" type="String" value="_r_66_67_69_79_84"/>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Continuous_Feed_Printers">
            <attributes name="id" type="String" value="_r_66_67_70"/>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Wide_Format_Solutions">
            <attributes name="id" type="String" value="_r_66_67_71"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="Color_Wide_Format_Printers">
                <attributes name="id" type="String" value="_r_66_67_71_85_86"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Digital_Wide_Format_Printers_and_Copiers">
                <attributes name="id" type="String" value="_r_66_67_71_85_87"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Wide_Format_Finishers">
                <attributes name="id" type="String" value="_r_66_67_71_85_88"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Software_Solutions">
                <attributes name="id" type="String" value="_r_66_67_71_85_89"/>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Workflow_software">
            <attributes name="id" type="String" value="_r_66_67_72"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="Freeflow_Software_and_scanners">
                <attributes name="id" type="String" value="_r_66_67_72_90_91"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="DFEs_and_controllers">
                <attributes name="id" type="String" value="_r_66_67_72_90_92"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Production_printing_software">
                <attributes name="id" type="String" value="_r_66_67_72_90_93"/>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Business_Development">
            <attributes name="id" type="String" value="_r_66_67_73"/>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
    <groups minCardinality="1" maxCardinality="1">
      <childFeatures maxCardinality="1" name="Products">
        <attributes name="id" type="String" value="_r_94"/>
        <groups minCardinality="1" maxCardinality="1">
          <childFeatures maxCardinality="1" name="Mono_Products">
            <attributes name="id" type="String" value="_r_94_95_96"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="BB">
                <attributes name="id" type="String" value="_r_94_95_96_98_99"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="QM">
                <attributes name="id" type="String" value="_r_94_95_96_98_100"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Teak">
                <attributes name="id" type="String" value="_r_94_95_96_98_101"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="HLC">
                <attributes name="id" type="String" value="_r_94_95_96_98_102"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Nuvera">
                <attributes name="id" type="String" value="_r_94_95_96_98_103"/>
              </childFeatures>
            </groups>
          </childFeatures>
          <childFeatures maxCardinality="1" name="Color_Products">
            <attributes name="id" type="String" value="_r_94_95_97"/>
            <groups minCardinality="1" maxCardinality="1">
              <childFeatures maxCardinality="1" name="Mykonos">
                <attributes name="id" type="String" value="_r_94_95_97_104_105"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Malta">
                <attributes name="id" type="String" value="_r_94_95_97_104_106"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Chandon">
                <attributes name="id" type="String" value="_r_94_95_97_104_107"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Chamonix">
                <attributes name="id" type="String" value="_r_94_95_97_104_108"/>
              </childFeatures>
              <childFeatures maxCardinality="1" name="Pinot">
                <attributes name="id" type="String" value="_r_94_95_97_104_109"/>
              </childFeatures>
            </groups>
          </childFeatures>
        </groups>
      </childFeatures>
    </groups>
  </root>
</feature:FeatureModel>
