package org.assimbly.edifactstandards.xml.envelope;

import org.assimbly.edifactcommon.text.edi.*;

public class INVOICD96AEnvelope extends TextDocument
{
    // EDI Fields

    static StructureItem mFieldF0001 = null;
    static StructureItem getFieldF0001() {  if (mFieldF0001 == null) initFieldF0001(); return mFieldF0001; }
    static void initFieldF0001 ()  { mFieldF0001 = new DataElement ("F0001",
            new  DataTypeValidatorString(4, 4,  null  )  ); }

    static StructureItem mFieldF0002 = null;
    static StructureItem getFieldF0002() {  if (mFieldF0002 == null) initFieldF0002(); return mFieldF0002; }
    static void initFieldF0002 ()  { mFieldF0002 = new DataElement ("F0002",
            new  DataTypeValidatorString(1, 1,  null  )  ); }

    static StructureItem mFieldF0004 = null;
    static StructureItem getFieldF0004() {  if (mFieldF0004 == null) initFieldF0004(); return mFieldF0004; }
    static void initFieldF0004 ()  { mFieldF0004 = new DataElement ("F0004",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0007 = null;
    static StructureItem getFieldF0007() {  if (mFieldF0007 == null) initFieldF0007(); return mFieldF0007; }
    static void initFieldF0007 ()  { mFieldF0007 = new DataElement ("F0007",
            new  DataTypeValidatorString(0, 4,  null  )  ); }

    static StructureItem mFieldF0008 = null;
    static StructureItem getFieldF0008() {  if (mFieldF0008 == null) initFieldF0008(); return mFieldF0008; }
    static void initFieldF0008 ()  { mFieldF0008 = new DataElement ("F0008",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0010 = null;
    static StructureItem getFieldF0010() {  if (mFieldF0010 == null) initFieldF0010(); return mFieldF0010; }
    static void initFieldF0010 ()  { mFieldF0010 = new DataElement ("F0010",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0014 = null;
    static StructureItem getFieldF0014() {  if (mFieldF0014 == null) initFieldF0014(); return mFieldF0014; }
    static void initFieldF0014 ()  { mFieldF0014 = new DataElement ("F0014",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0017 = null;
    static StructureItem getFieldF0017() {  if (mFieldF0017 == null) initFieldF0017(); return mFieldF0017; }
    static void initFieldF0017 ()  { mFieldF0017 = new DataElement ("F0017",
            new  DataTypeValidatorDecimal(6, 8, 0)  ); }

    static StructureItem mFieldF0019 = null;
    static StructureItem getFieldF0019() {  if (mFieldF0019 == null) initFieldF0019(); return mFieldF0019; }
    static void initFieldF0019 ()  { mFieldF0019 = new DataElement ("F0019",
            new  DataTypeValidatorDecimal(4, 4, 0)  ); }

    static StructureItem mFieldF0020 = null;
    static StructureItem getFieldF0020() {  if (mFieldF0020 == null) initFieldF0020(); return mFieldF0020; }
    static void initFieldF0020 ()  { mFieldF0020 = new DataElement ("F0020",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0022 = null;
    static StructureItem getFieldF0022() {  if (mFieldF0022 == null) initFieldF0022(); return mFieldF0022; }
    static void initFieldF0022 ()  { mFieldF0022 = new DataElement ("F0022",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0025 = null;
    static StructureItem getFieldF0025() {  if (mFieldF0025 == null) initFieldF0025(); return mFieldF0025; }
    static void initFieldF0025 ()  { mFieldF0025 = new DataElement ("F0025",
            new  DataTypeValidatorString(2, 2,  null  )  ); }

    static StructureItem mFieldF0026 = null;
    static StructureItem getFieldF0026() {  if (mFieldF0026 == null) initFieldF0026(); return mFieldF0026; }
    static void initFieldF0026 ()  { mFieldF0026 = new DataElement ("F0026",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0029 = null;
    static StructureItem getFieldF0029() {  if (mFieldF0029 == null) initFieldF0029(); return mFieldF0029; }
    static void initFieldF0029 ()  { mFieldF0029 = new DataElement ("F0029",
            new  DataTypeValidatorString(1, 1,  null  )  ); }

    static StructureItem mFieldF0031 = null;
    static StructureItem getFieldF0031() {  if (mFieldF0031 == null) initFieldF0031(); return mFieldF0031; }
    static void initFieldF0031 ()  { mFieldF0031 = new DataElement ("F0031",
            new  DataTypeValidatorDecimal(1, 1, 0)  ); }

    static StructureItem mFieldF0032 = null;
    static StructureItem getFieldF0032() {  if (mFieldF0032 == null) initFieldF0032(); return mFieldF0032; }
    static void initFieldF0032 ()  { mFieldF0032 = new DataElement ("F0032",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0035 = null;
    static StructureItem getFieldF0035() {  if (mFieldF0035 == null) initFieldF0035(); return mFieldF0035; }
    static void initFieldF0035 ()  { mFieldF0035 = new DataElement ("F0035",
            new  DataTypeValidatorDecimal(1, 1, 0)  ); }

    static StructureItem mFieldF0036 = null;
    static StructureItem getFieldF0036() {  if (mFieldF0036 == null) initFieldF0036(); return mFieldF0036; }
    static void initFieldF0036 ()  { mFieldF0036 = new DataElement ("F0036",
            new  DataTypeValidatorDecimal(0, 6, 0)  ); }

    static StructureItem mFieldF0038 = null;
    static StructureItem getFieldF0038() {  if (mFieldF0038 == null) initFieldF0038(); return mFieldF0038; }
    static void initFieldF0038 ()  { mFieldF0038 = new DataElement ("F0038",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF0040 = null;
    static StructureItem getFieldF0040() {  if (mFieldF0040 == null) initFieldF0040(); return mFieldF0040; }
    static void initFieldF0040 ()  { mFieldF0040 = new DataElement ("F0040",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0042 = null;
    static StructureItem getFieldF0042() {  if (mFieldF0042 == null) initFieldF0042(); return mFieldF0042; }
    static void initFieldF0042 ()  { mFieldF0042 = new DataElement ("F0042",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0044 = null;
    static StructureItem getFieldF0044() {  if (mFieldF0044 == null) initFieldF0044(); return mFieldF0044; }
    static void initFieldF0044 ()  { mFieldF0044 = new DataElement ("F0044",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0046 = null;
    static StructureItem getFieldF0046() {  if (mFieldF0046 == null) initFieldF0046(); return mFieldF0046; }
    static void initFieldF0046 ()  { mFieldF0046 = new DataElement ("F0046",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0048 = null;
    static StructureItem getFieldF0048() {  if (mFieldF0048 == null) initFieldF0048(); return mFieldF0048; }
    static void initFieldF0048 ()  { mFieldF0048 = new DataElement ("F0048",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0051 = null;
    static StructureItem getFieldF0051() {  if (mFieldF0051 == null) initFieldF0051(); return mFieldF0051; }
    static void initFieldF0051 ()  { mFieldF0051 = new DataElement ("F0051",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0052 = null;
    static StructureItem getFieldF0052() {  if (mFieldF0052 == null) initFieldF0052(); return mFieldF0052; }
    static void initFieldF0052 ()  { mFieldF0052 = new DataElement ("F0052",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0054 = null;
    static StructureItem getFieldF0054() {  if (mFieldF0054 == null) initFieldF0054(); return mFieldF0054; }
    static void initFieldF0054 ()  { mFieldF0054 = new DataElement ("F0054",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0057 = null;
    static StructureItem getFieldF0057() {  if (mFieldF0057 == null) initFieldF0057(); return mFieldF0057; }
    static void initFieldF0057 ()  { mFieldF0057 = new DataElement ("F0057",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF0058 = null;
    static StructureItem getFieldF0058() {  if (mFieldF0058 == null) initFieldF0058(); return mFieldF0058; }
    static void initFieldF0058 ()  { mFieldF0058 = new DataElement ("F0058",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0060 = null;
    static StructureItem getFieldF0060() {  if (mFieldF0060 == null) initFieldF0060(); return mFieldF0060; }
    static void initFieldF0060 ()  { mFieldF0060 = new DataElement ("F0060",
            new  DataTypeValidatorDecimal(0, 6, 0)  ); }

    static StructureItem mFieldF0062 = null;
    static StructureItem getFieldF0062() {  if (mFieldF0062 == null) initFieldF0062(); return mFieldF0062; }
    static void initFieldF0062 ()  { mFieldF0062 = new DataElement ("F0062",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0065 = null;
    static StructureItem getFieldF0065() {  if (mFieldF0065 == null) initFieldF0065(); return mFieldF0065; }
    static void initFieldF0065 ()  { mFieldF0065 = new DataElement ("F0065",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF0068 = null;
    static StructureItem getFieldF0068() {  if (mFieldF0068 == null) initFieldF0068(); return mFieldF0068; }
    static void initFieldF0068 ()  { mFieldF0068 = new DataElement ("F0068",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF0070 = null;
    static StructureItem getFieldF0070() {  if (mFieldF0070 == null) initFieldF0070(); return mFieldF0070; }
    static void initFieldF0070 ()  { mFieldF0070 = new DataElement ("F0070",
            new  DataTypeValidatorDecimal(0, 2, 0)  ); }

    static StructureItem mFieldF0073 = null;
    static StructureItem getFieldF0073() {  if (mFieldF0073 == null) initFieldF0073(); return mFieldF0073; }
    static void initFieldF0073 ()  { mFieldF0073 = new DataElement ("F0073",
            new  DataTypeValidatorString(1, 1,  null  )  ); }

    static StructureItem mFieldF0074 = null;
    static StructureItem getFieldF0074() {  if (mFieldF0074 == null) initFieldF0074(); return mFieldF0074; }
    static void initFieldF0074 ()  { mFieldF0074 = new DataElement ("F0074",
            new  DataTypeValidatorDecimal(0, 10, 0)  ); }

    static StructureItem mFieldF0076 = null;
    static StructureItem getFieldF0076() {  if (mFieldF0076 == null) initFieldF0076(); return mFieldF0076; }
    static void initFieldF0076 ()  { mFieldF0076 = new DataElement ("F0076",
            new  DataTypeValidatorString(2, 2,  null  )  ); }

    static StructureItem mFieldF0080 = null;
    static StructureItem getFieldF0080() {  if (mFieldF0080 == null) initFieldF0080(); return mFieldF0080; }
    static void initFieldF0080 ()  { mFieldF0080 = new DataElement ("F0080",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF0081 = null;
    static StructureItem getFieldF0081() {  if (mFieldF0081 == null) initFieldF0081(); return mFieldF0081; }
    static void initFieldF0081 ()  { mFieldF0081 = new DataElement ("F0081",
            new  DataTypeValidatorString(1, 1,  null  )  ); }

    static StructureItem mFieldF0110 = null;
    static StructureItem getFieldF0110() {  if (mFieldF0110 == null) initFieldF0110(); return mFieldF0110; }
    static void initFieldF0110 ()  { mFieldF0110 = new DataElement ("F0110",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF0113 = null;
    static StructureItem getFieldF0113() {  if (mFieldF0113 == null) initFieldF0113(); return mFieldF0113; }
    static void initFieldF0113 ()  { mFieldF0113 = new DataElement ("F0113",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF0115 = null;
    static StructureItem getFieldF0115() {  if (mFieldF0115 == null) initFieldF0115(); return mFieldF0115; }
    static void initFieldF0115 ()  { mFieldF0115 = new DataElement ("F0115",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0116 = null;
    static StructureItem getFieldF0116() {  if (mFieldF0116 == null) initFieldF0116(); return mFieldF0116; }
    static void initFieldF0116 ()  { mFieldF0116 = new DataElement ("F0116",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0118 = null;
    static StructureItem getFieldF0118() {  if (mFieldF0118 == null) initFieldF0118(); return mFieldF0118; }
    static void initFieldF0118 ()  { mFieldF0118 = new DataElement ("F0118",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0121 = null;
    static StructureItem getFieldF0121() {  if (mFieldF0121 == null) initFieldF0121(); return mFieldF0121; }
    static void initFieldF0121 ()  { mFieldF0121 = new DataElement ("F0121",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0122 = null;
    static StructureItem getFieldF0122() {  if (mFieldF0122 == null) initFieldF0122(); return mFieldF0122; }
    static void initFieldF0122 ()  { mFieldF0122 = new DataElement ("F0122",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0124 = null;
    static StructureItem getFieldF0124() {  if (mFieldF0124 == null) initFieldF0124(); return mFieldF0124; }
    static void initFieldF0124 ()  { mFieldF0124 = new DataElement ("F0124",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0127 = null;
    static StructureItem getFieldF0127() {  if (mFieldF0127 == null) initFieldF0127(); return mFieldF0127; }
    static void initFieldF0127 ()  { mFieldF0127 = new DataElement ("F0127",
            new  DataTypeValidatorString(0, 14,  null  )  ); }

    static StructureItem mFieldF0128 = null;
    static StructureItem getFieldF0128() {  if (mFieldF0128 == null) initFieldF0128(); return mFieldF0128; }
    static void initFieldF0128 ()  { mFieldF0128 = new DataElement ("F0128",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0130 = null;
    static StructureItem getFieldF0130() {  if (mFieldF0130 == null) initFieldF0130(); return mFieldF0130; }
    static void initFieldF0130 ()  { mFieldF0130 = new DataElement ("F0130",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF0133 = null;
    static StructureItem getFieldF0133() {  if (mFieldF0133 == null) initFieldF0133(); return mFieldF0133; }
    static void initFieldF0133 ()  { mFieldF0133 = new DataElement ("F0133",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF1000 = null;
    static StructureItem getFieldF1000() {  if (mFieldF1000 == null) initFieldF1000(); return mFieldF1000; }
    static void initFieldF1000 ()  { mFieldF1000 = new DataElement ("F1000",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF1001 = null;
    static void initCodeListF1001 () { mCodeListF1001 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","105","110","120","130","140","150","190","201","202","203","204","205","206","207","208","209","210","211","212","215","220","221","222","223","224","225","226","227","228","229","230","231","232","233","240","241","242","245","270","271","310","311","315","320","325","326","327","328","330","335","340","341","343","345","350","351","370","380","381","382","383","384","385","386","387","388","389","390","393","394","395","396","409","412","425","426","427","428","429","430","431","435","447","448","450","451","452","454","455","456","457","458","460","465","466","467","468","469","481","485","490","491","492","493","520","530","550","575","580","610","621","622","623","624","630","631","632","633","635","640","650","655","700","701","702","703","704","705","706","707","708","709","710","711","712","713","714","715","716","720","722","723","724","730","740","741","743","744","745","746","750","760","761","763","764","765","766","770","775","780","781","782","783","784","785","786","787","788","789","790","791","792","793","794","795","796","797","798","799","810","811","812","820","821","822","823","824","825","830","833","840","841","850","851","852","853","855","856","860","861","862","863","864","865","870","890","895","896","901","910","911","913","914","915","916","917","925","926","927","929","930","931","932","933","934","935","936","937","938","940","941","950","951","952","953","954","955","960","961","962","963","964","965","966","990","991","995","996","998" }; }
    static StructureItem mFieldF1001 = null;
    static StructureItem getFieldF1001() { initCodeListF1001(); if (mFieldF1001 == null) initFieldF1001(); return mFieldF1001; }
    static void initFieldF1001 ()  { mFieldF1001 = new DataElement ("F1001",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1001  ))  ); }

    static StructureItem mFieldF1004 = null;
    static StructureItem getFieldF1004() {  if (mFieldF1004 == null) initFieldF1004(); return mFieldF1004; }
    static void initFieldF1004 ()  { mFieldF1004 = new DataElement ("F1004",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF1082 = null;
    static StructureItem getFieldF1082() {  if (mFieldF1082 == null) initFieldF1082(); return mFieldF1082; }
    static void initFieldF1082 ()  { mFieldF1082 = new DataElement ("F1082",
            new  DataTypeValidatorDecimal(0, 6, 0)  ); }

    static String[] mCodeListF1131 = null;
    static void initCodeListF1131 () { mCodeListF1131 =
            new String[] { "12","16","23","25","35","36","37","38","39","42","43","44","52","53","54","55","56","57","58","59","60","61","62","63","64","65","67","68","69","70","71","100","101","102","103","104","105","106","107","108","109","110","112","113","114","115","116","117","118","119","120","121","122","123","125","126","127","128","129","130","131","132","133","134","135","136","137","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","160","161","162","163","164","165","166","167","168","169","170","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","ZZZ" }; }
    static StructureItem mFieldF1131 = null;
    static StructureItem getFieldF1131() { initCodeListF1131(); if (mFieldF1131 == null) initFieldF1131(); return mFieldF1131; }
    static void initFieldF1131 ()  { mFieldF1131 = new DataElement ("F1131",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1131  ))  ); }

    static String[] mCodeListF1153 = null;
    static void initCodeListF1153 () { mCodeListF1153 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAG","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAS","AAT","AAU","AAV","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABG","ABH","ABI","ABJ","ABK","ABL","ABO","ABP","ABQ","ABR","ABS","ABT","ABU","ABW","ABX","ABY","ABZ","AC","ACB","ACC","ACD","ACE","ACF","ACG","ACH","ACI","ACJ","ACK","ACL","ACM","ACN","ACO","ACP","ACQ","ACR","ACS","ACT","ACU","ACW","ACX","ACY","ACZ","ADA","ADB","ADC","ADD","ADE","ADF","ADG","ADH","ADI","ADJ","ADK","ADP","ADQ","ADR","ADS","ADT","ADU","ADV","ADW","ADY","ADZ","AE","AEA","AEB","AEC","AED","AEE","AEF","AEG","AEH","AEI","AEJ","AEK","AEL","AEM","AEN","AEO","AEP","AEQ","AER","AES","AET","AEU","AEV","AEW","AEX","AEY","AEZ","AF","AFA","AFB","AFC","AFD","AFE","AFF","AFG","AFI","AFJ","AFK","AFL","AFM","AFN","AFO","AFP","AFQ","AFR","AFS","AFT","AFU","AFV","AFW","AFX","AFY","AFZ","AGA","AGB","AGC","AGD","AGE","AGF","AGG","AGH","AGI","AGJ","AGK","AGL","AGM","AGN","AGO","AGP","AGQ","AGR","AGS","AGT","AGU","AGV","AGW","AGX","AGY","AGZ","AHA","AHB","AHC","AHD","AHE","AHF","AHG","AHH","AHI","AHJ","AHK","AHL","AHM","AHN","AHO","AHP","AHQ","AHR","AHS","AHT","AHU","AHV","AHW","AHX","AHY","AHZ","AIA","AIB","AIC","AID","AIE","AIF","AIG","AIH","AII","AIJ","AIK","AIL","AIM","AIN","AIO","AIP","AIQ","AIR","AIS","AIT","AIU","AIV","AIW","AIX","AIY","ALA","ALB","ALC","ALD","ALE","ALF","ALG","ALH","ALI","ALJ","ALK","ALL","ALM","ALN","ALO","ALP","ALQ","ALR","ALS","ALT","ALU","ALV","ALW","ALX","ALY","ALZ","AMA","AMB","AMC","AP","ASC","AU","AV","AWB","BA","BC","BD","BE","BH","BM","BN","BO","BR","BT","BW","CAS","CD","CEC","CFE","CFO","CG","CH","CK","CKN","CM","CMR","CN","CNO","CO","COF","CP","CR","CRN","CS","CST","CT","CU","CV","CW","CZ","DA","DAN","DB","DI","DL","DM","DQ","DR","EA","EB","ED","EE","EI","EN","EP","EQ","ER","ERN","ET","EX","FC","FF","FI","FLW","FN","FO","FS","FT","FV","FX","GA","GC","GD","GDN","GN","HS","HWB","IA","IB","ICA","ICE","ICO","II","IL","INB","INN","INO","IP","IS","IT","IV","JB","JE","LA","LAN","LAR","LB","LC","LI","LO","LS","MA","MB","MF","MG","MH","MR","MRN","MS","MSS","MWB","NA","OH","OI","ON","OP","OR","PB","PC","PD","PE","PF","PI","PK","PL","POR","PP","PQ","PR","PS","PW","PY","RA","RC","RCN","RE","REN","RF","RR","RT","SA","SB","SD","SE","SF","SH","SI","SM","SN","SP","SQ","SRN","SS","STA","SW","SZ","TB","TE","TF","TI","TL","TN","TP","UAR","UC","UCN","UN","UO","VA","VC","VM","VN","VON","VP","VR","VS","VT","VV","WE","WM","WN","WR","WS","WY","XA","XC","XP","ZZZ" }; }
    static StructureItem mFieldF1153 = null;
    static StructureItem getFieldF1153() { initCodeListF1153(); if (mFieldF1153 == null) initFieldF1153(); return mFieldF1153; }
    static void initFieldF1153 ()  { mFieldF1153 = new DataElement ("F1153",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1153  ))  ); }

    static StructureItem mFieldF1154 = null;
    static StructureItem getFieldF1154() {  if (mFieldF1154 == null) initFieldF1154(); return mFieldF1154; }
    static void initFieldF1154 ()  { mFieldF1154 = new DataElement ("F1154",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF1156 = null;
    static StructureItem getFieldF1156() {  if (mFieldF1156 == null) initFieldF1156(); return mFieldF1156; }
    static void initFieldF1156 ()  { mFieldF1156 = new DataElement ("F1156",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF1218 = null;
    static StructureItem getFieldF1218() {  if (mFieldF1218 == null) initFieldF1218(); return mFieldF1218; }
    static void initFieldF1218 ()  { mFieldF1218 = new DataElement ("F1218",
            new  DataTypeValidatorDecimal(0, 2, 0)  ); }

    static StructureItem mFieldF1220 = null;
    static StructureItem getFieldF1220() {  if (mFieldF1220 == null) initFieldF1220(); return mFieldF1220; }
    static void initFieldF1220 ()  { mFieldF1220 = new DataElement ("F1220",
            new  DataTypeValidatorDecimal(0, 2, 0)  ); }

    static StructureItem mFieldF1222 = null;
    static StructureItem getFieldF1222() {  if (mFieldF1222 == null) initFieldF1222(); return mFieldF1222; }
    static void initFieldF1222 ()  { mFieldF1222 = new DataElement ("F1222",
            new  DataTypeValidatorDecimal(0, 2, 0)  ); }

    static String[] mCodeListF1225 = null;
    static void initCodeListF1225 () { mCodeListF1225 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54" }; }
    static StructureItem mFieldF1225 = null;
    static StructureItem getFieldF1225() { initCodeListF1225(); if (mFieldF1225 == null) initFieldF1225(); return mFieldF1225; }
    static void initFieldF1225 ()  { mFieldF1225 = new DataElement ("F1225",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1225  ))  ); }

    static String[] mCodeListF1227 = null;
    static void initCodeListF1227 () { mCodeListF1227 =
            new String[] { "1","2","3","4","5","6","7","8","9" }; }
    static StructureItem mFieldF1227 = null;
    static StructureItem getFieldF1227() { initCodeListF1227(); if (mFieldF1227 == null) initFieldF1227(); return mFieldF1227; }
    static void initFieldF1227 ()  { mFieldF1227 = new DataElement ("F1227",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1227  ))  ); }

    static String[] mCodeListF1229 = null;
    static void initCodeListF1229 () { mCodeListF1229 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" }; }
    static StructureItem mFieldF1229 = null;
    static StructureItem getFieldF1229() { initCodeListF1229(); if (mFieldF1229 == null) initFieldF1229(); return mFieldF1229; }
    static void initFieldF1229 ()  { mFieldF1229 = new DataElement ("F1229",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1229  ))  ); }

    static StructureItem mFieldF1230 = null;
    static StructureItem getFieldF1230() {  if (mFieldF1230 == null) initFieldF1230(); return mFieldF1230; }
    static void initFieldF1230 ()  { mFieldF1230 = new DataElement ("F1230",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF1366 = null;
    static StructureItem getFieldF1366() {  if (mFieldF1366 == null) initFieldF1366(); return mFieldF1366; }
    static void initFieldF1366 ()  { mFieldF1366 = new DataElement ("F1366",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF1373 = null;
    static void initCodeListF1373 () { mCodeListF1373 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21" }; }
    static StructureItem mFieldF1373 = null;
    static StructureItem getFieldF1373() { initCodeListF1373(); if (mFieldF1373 == null) initFieldF1373(); return mFieldF1373; }
    static void initFieldF1373 ()  { mFieldF1373 = new DataElement ("F1373",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1373  ))  ); }

    static String[] mCodeListF2005 = null;
    static void initCodeListF2005 () { mCodeListF2005 =
            new String[] { "2","3","4","7","8","9","10","11","12","13","14","15","16","17","18","20","21","22","35","36","37","38","39","42","44","45","46","47","48","49","50","51","52","53","54","55","58","59","60","61","63","64","65","67","69","71","72","74","75","76","79","81","84","85","89","90","91","92","93","94","95","96","97","101","107","108","109","110","111","113","114","115","117","119","123","124","125","126","128","129","131","132","133","134","135","136","137","138","140","141","143","144","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","218","219","221","222","223","224","225","226","227","228","229","230","231","232","233","234","235","236","237","238","239","240","242","243","244","245","246","247","248","249","250","251","252","253","254","255","257","258","259","260","261","262","263","264","265","266","267","268","270","271","272","273","274","275","276","277","278","279","280","281","282","283","284","285","286","287","288","290","291","292","293","294","295","296","297","298","299","300","301","302","303","304","305","306","307","308","309","310","311","312","313","314","315","316","317","318","319","320","321","322","323","324","325","326","327","328","329","330","331","332","333","334","335","336","337","338","339","340","341","342","343","344","345","346","347","348","349","350","351","352","353","354","355","356","357","358","359","360","361","362","363","364","365","366","367","368","369","370","371","372","373","374","375","376","377","378","379","ZZZ" }; }
    static StructureItem mFieldF2005 = null;
    static StructureItem getFieldF2005() { initCodeListF2005(); if (mFieldF2005 == null) initFieldF2005(); return mFieldF2005; }
    static void initFieldF2005 ()  { mFieldF2005 = new DataElement ("F2005",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF2005  ))  ); }

    static String[] mCodeListF2009 = null;
    static void initCodeListF2009 () { mCodeListF2009 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12" }; }
    static StructureItem mFieldF2009 = null;
    static StructureItem getFieldF2009() { initCodeListF2009(); if (mFieldF2009 == null) initFieldF2009(); return mFieldF2009; }
    static void initFieldF2009 ()  { mFieldF2009 = new DataElement ("F2009",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF2009  ))  ); }

    static String[] mCodeListF2151 = null;
    static void initCodeListF2151 () { mCodeListF2151 =
            new String[] { "3M","6M","AA","AD","CD","CW","D","DC","DW","F","H","HM","M","MN","P","S","SD","SI","W","WD","WW","Y","ZZZ" }; }
    static StructureItem mFieldF2151 = null;
    static StructureItem getFieldF2151() { initCodeListF2151(); if (mFieldF2151 == null) initFieldF2151(); return mFieldF2151; }
    static void initFieldF2151 ()  { mFieldF2151 = new DataElement ("F2151",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF2151  ))  ); }

    static StructureItem mFieldF2152 = null;
    static StructureItem getFieldF2152() {  if (mFieldF2152 == null) initFieldF2152(); return mFieldF2152; }
    static void initFieldF2152 ()  { mFieldF2152 = new DataElement ("F2152",
            new  DataTypeValidatorDecimal(0, 3, 0)  ); }

    static String[] mCodeListF2379 = null;
    static void initCodeListF2379 () { mCodeListF2379 =
            new String[] { "2","3","101","102","103","105","106","107","108","109","110","201","202","203","204","301","302","303","304","305","306","401","402","404","405","501","502","503","600","601","602","603","604","608","609","610","613","614","615","616","701","702","703","704","705","706","707","708","709","710","711","713","715","716","717","718","801","802","803","804","805","806","807","808","809","810","811","812","813","814" }; }
    static StructureItem mFieldF2379 = null;
    static StructureItem getFieldF2379() { initCodeListF2379(); if (mFieldF2379 == null) initFieldF2379(); return mFieldF2379; }
    static void initFieldF2379 ()  { mFieldF2379 = new DataElement ("F2379",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF2379  ))  ); }

    static StructureItem mFieldF2380 = null;
    static StructureItem getFieldF2380() {  if (mFieldF2380 == null) initFieldF2380(); return mFieldF2380; }
    static void initFieldF2380 ()  { mFieldF2380 = new DataElement ("F2380",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF2475 = null;
    static void initCodeListF2475 () { mCodeListF2475 =
            new String[] { "1","2","3","4","5","6","7","8","9","11","12","13","14","21","22","23","24","25","26","27","28","29","31","32","33","41","42","43","44","45","46","47","48","52","53","54","55","56","57","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","ZZZ" }; }
    static StructureItem mFieldF2475 = null;
    static StructureItem getFieldF2475() { initCodeListF2475(); if (mFieldF2475 == null) initFieldF2475(); return mFieldF2475; }
    static void initFieldF2475 ()  { mFieldF2475 = new DataElement ("F2475",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF2475  ))  ); }

    static String[] mCodeListF3035 = null;
    static void initCodeListF3035 () { mCodeListF3035 =
            new String[] { "AA","AB","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AT","AU","AV","AW","AX","AZ","B1","B2","BA","BB","BC","BD","BE","BF","BG","BH","BI","BK","BL","BM","BN","BO","BP","BQ","BS","BT","BU","BV","BW","BX","BY","BZ","C1","C2","CA","CB","CC","CD","CE","CF","CG","CH","CI","CJ","CK","CL","CM","CN","CO","COP","CP","CPD","CQ","CR","CS","CT","CU","CV","CW","CX","CY","CZ","DA","DB","DC","DCP","DD","DE","DF","DG","DH","DI","DJ","DK","DL","DM","DN","DO","DP","DQ","DR","DS","DT","DU","DV","DW","DX","DY","DZ","EA","EB","EC","ED","EE","EF","EG","EH","EI","EJ","EK","EL","EM","EN","EO","EP","EQ","ER","ES","ET","EU","EV","EW","EX","EY","EZ","FA","FB","FC","FD","FE","FF","FG","FH","FJ","FK","FL","FM","FN","FO","FP","FR","FT","FW","FX","FY","FZ","GA","GB","GC","GD","GE","GF","GG","GH","GI","GJ","GK","GL","GM","GN","GO","GP","GQ","GR","GS","GT","GU","GV","GW","GX","GY","GZ","I1","I2","IB","IC","ID","IE","IF","IG","IH","II","IJ","IL","IM","IN","IO","IP","IQ","IR","IS","IT","IU","IV","IW","LA","LB","LN","LP","MA","MF","MG","MI","MP","MR","MS","MT","N1","N2","NI","OA","OB","OF","OI","OO","OP","OR","OS","OT","OV","OY","P1","P2","P3","P4","PA","PB","PC","PD","PE","PF","PG","PH","PI","PJ","PK","PL","PM","PN","PO","PQ","PR","PS","PT","PW","PX","PY","PZ","RA","RB","RE","RF","RH","RI","RL","RM","RP","RS","RV","RW","SB","SE","SF","SG","SI","SK","SN","SO","SR","SS","ST","SU","SX","SY","SZ","TC","TCP","TD","TR","TS","TT","UC","UD","UHP","UP","VN","WD","WH","WM","WPA","WS","XX","ZZZ" }; }
    static StructureItem mFieldF3035 = null;
    static StructureItem getFieldF3035() { initCodeListF3035(); if (mFieldF3035 == null) initFieldF3035(); return mFieldF3035; }
    static void initFieldF3035 ()  { mFieldF3035 = new DataElement ("F3035",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3035  ))  ); }

    static StructureItem mFieldF3036 = null;
    static StructureItem getFieldF3036() {  if (mFieldF3036 == null) initFieldF3036(); return mFieldF3036; }
    static void initFieldF3036 ()  { mFieldF3036 = new DataElement ("F3036",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF3039 = null;
    static StructureItem getFieldF3039() {  if (mFieldF3039 == null) initFieldF3039(); return mFieldF3039; }
    static void initFieldF3039 ()  { mFieldF3039 = new DataElement ("F3039",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF3042 = null;
    static StructureItem getFieldF3042() {  if (mFieldF3042 == null) initFieldF3042(); return mFieldF3042; }
    static void initFieldF3042 ()  { mFieldF3042 = new DataElement ("F3042",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF3045 = null;
    static void initCodeListF3045 () { mCodeListF3045 =
            new String[] { "1" }; }
    static StructureItem mFieldF3045 = null;
    static StructureItem getFieldF3045() { initCodeListF3045(); if (mFieldF3045 == null) initFieldF3045(); return mFieldF3045; }
    static void initFieldF3045 ()  { mFieldF3045 = new DataElement ("F3045",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3045  ))  ); }

    static String[] mCodeListF3055 = null;
    static void initCodeListF3055 () { mCodeListF3055 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","181","182","183","184","ZZZ" }; }
    static StructureItem mFieldF3055 = null;
    static StructureItem getFieldF3055() { initCodeListF3055(); if (mFieldF3055 == null) initFieldF3055(); return mFieldF3055; }
    static void initFieldF3055 ()  { mFieldF3055 = new DataElement ("F3055",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3055  ))  ); }

    static StructureItem mFieldF3124 = null;
    static StructureItem getFieldF3124() {  if (mFieldF3124 == null) initFieldF3124(); return mFieldF3124; }
    static void initFieldF3124 ()  { mFieldF3124 = new DataElement ("F3124",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF3127 = null;
    static StructureItem getFieldF3127() {  if (mFieldF3127 == null) initFieldF3127(); return mFieldF3127; }
    static void initFieldF3127 ()  { mFieldF3127 = new DataElement ("F3127",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF3128 = null;
    static StructureItem getFieldF3128() {  if (mFieldF3128 == null) initFieldF3128(); return mFieldF3128; }
    static void initFieldF3128 ()  { mFieldF3128 = new DataElement ("F3128",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF3139 = null;
    static void initCodeListF3139 () { mCodeListF3139 =
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","AZ","BA","BB","BC","BD","BE","BF","BU","CA","CB","CC","CD","CE","CF","CG","CN","CO","CP","CR","CW","DE","DI","DL","EB","EC","ED","EX","GR","HE","HG","HM","IC","IN","LB","LO","MC","MD","MH","MR","MS","NT","OC","PA","PD","PE","PM","QA","QC","RD","SA","SC","SD","SR","SU","TA","TD","TI","TR","WH","ZZZ" }; }
    static StructureItem mFieldF3139 = null;
    static StructureItem getFieldF3139() { initCodeListF3139(); if (mFieldF3139 == null) initFieldF3139(); return mFieldF3139; }
    static void initFieldF3139 ()  { mFieldF3139 = new DataElement ("F3139",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3139  ))  ); }

    static StructureItem mFieldF3148 = null;
    static StructureItem getFieldF3148() {  if (mFieldF3148 == null) initFieldF3148(); return mFieldF3148; }
    static void initFieldF3148 ()  { mFieldF3148 = new DataElement ("F3148",
            new  DataTypeValidatorString(0, 512,  null  )  ); }

    static String[] mCodeListF3153 = null;
    static void initCodeListF3153 () { mCodeListF3153 =
            new String[] { "AA","AB","AC","CA","EI","EM","EX","FT","FX","GM","IE","IM","MA","PB","PS","SW","TE","TG","TL","TM","TT","TX","XF" }; }
    static StructureItem mFieldF3153 = null;
    static StructureItem getFieldF3153() { initCodeListF3153(); if (mFieldF3153 == null) initFieldF3153(); return mFieldF3153; }
    static void initFieldF3153 ()  { mFieldF3153 = new DataElement ("F3153",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3153  ))  ); }

    static String[] mCodeListF3155 = null;
    static void initCodeListF3155 () { mCodeListF3155 =
            new String[] { "AA","AB","AC","AD","AE","CA","EI","EM","EX","FT","FX","GM","IE","IM","MA","PB","PS","SW","TE","TG","TL","TM","TT","TX","XF" }; }
    static StructureItem mFieldF3155 = null;
    static StructureItem getFieldF3155() { initCodeListF3155(); if (mFieldF3155 == null) initFieldF3155(); return mFieldF3155; }
    static void initFieldF3155 ()  { mFieldF3155 = new DataElement ("F3155",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3155  ))  ); }

    static StructureItem mFieldF3164 = null;
    static StructureItem getFieldF3164() {  if (mFieldF3164 == null) initFieldF3164(); return mFieldF3164; }
    static void initFieldF3164 ()  { mFieldF3164 = new DataElement ("F3164",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF3192 = null;
    static StructureItem getFieldF3192() {  if (mFieldF3192 == null) initFieldF3192(); return mFieldF3192; }
    static void initFieldF3192 ()  { mFieldF3192 = new DataElement ("F3192",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF3194 = null;
    static StructureItem getFieldF3194() {  if (mFieldF3194 == null) initFieldF3194(); return mFieldF3194; }
    static void initFieldF3194 ()  { mFieldF3194 = new DataElement ("F3194",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF3207 = null;
    static StructureItem getFieldF3207() {  if (mFieldF3207 == null) initFieldF3207(); return mFieldF3207; }
    static void initFieldF3207 ()  { mFieldF3207 = new DataElement ("F3207",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF3222 = null;
    static StructureItem getFieldF3222() {  if (mFieldF3222 == null) initFieldF3222(); return mFieldF3222; }
    static void initFieldF3222 ()  { mFieldF3222 = new DataElement ("F3222",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF3223 = null;
    static StructureItem getFieldF3223() {  if (mFieldF3223 == null) initFieldF3223(); return mFieldF3223; }
    static void initFieldF3223 ()  { mFieldF3223 = new DataElement ("F3223",
            new  DataTypeValidatorString(0, 25,  null  )  ); }

    static StructureItem mFieldF3224 = null;
    static StructureItem getFieldF3224() {  if (mFieldF3224 == null) initFieldF3224(); return mFieldF3224; }
    static void initFieldF3224 ()  { mFieldF3224 = new DataElement ("F3224",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF3225 = null;
    static StructureItem getFieldF3225() {  if (mFieldF3225 == null) initFieldF3225(); return mFieldF3225; }
    static void initFieldF3225 ()  { mFieldF3225 = new DataElement ("F3225",
            new  DataTypeValidatorString(0, 25,  null  )  ); }

    static String[] mCodeListF3227 = null;
    static void initCodeListF3227 () { mCodeListF3227 =
            new String[] { "1","2","4","5","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","60","61","62","64","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","113","114","115","116","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146","147","148","149","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","ZZZ" }; }
    static StructureItem mFieldF3227 = null;
    static StructureItem getFieldF3227() { initCodeListF3227(); if (mFieldF3227 == null) initFieldF3227(); return mFieldF3227; }
    static void initFieldF3227 ()  { mFieldF3227 = new DataElement ("F3227",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3227  ))  ); }

    static StructureItem mFieldF3229 = null;
    static StructureItem getFieldF3229() {  if (mFieldF3229 == null) initFieldF3229(); return mFieldF3229; }
    static void initFieldF3229 ()  { mFieldF3229 = new DataElement ("F3229",
            new  DataTypeValidatorString(0, 9,  null  )  ); }

    static StructureItem mFieldF3232 = null;
    static StructureItem getFieldF3232() {  if (mFieldF3232 == null) initFieldF3232(); return mFieldF3232; }
    static void initFieldF3232 ()  { mFieldF3232 = new DataElement ("F3232",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF3233 = null;
    static StructureItem getFieldF3233() {  if (mFieldF3233 == null) initFieldF3233(); return mFieldF3233; }
    static void initFieldF3233 ()  { mFieldF3233 = new DataElement ("F3233",
            new  DataTypeValidatorString(0, 25,  null  )  ); }

    static StructureItem mFieldF3239 = null;
    static StructureItem getFieldF3239() {  if (mFieldF3239 == null) initFieldF3239(); return mFieldF3239; }
    static void initFieldF3239 ()  { mFieldF3239 = new DataElement ("F3239",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF3251 = null;
    static StructureItem getFieldF3251() {  if (mFieldF3251 == null) initFieldF3251(); return mFieldF3251; }
    static void initFieldF3251 ()  { mFieldF3251 = new DataElement ("F3251",
            new  DataTypeValidatorString(0, 9,  null  )  ); }

    static String[] mCodeListF3285 = null;
    static void initCodeListF3285 () { mCodeListF3285 =
            new String[] { "1","2","3","4","5","6","7","8","9","10" }; }
    static StructureItem mFieldF3285 = null;
    static StructureItem getFieldF3285() { initCodeListF3285(); if (mFieldF3285 == null) initFieldF3285(); return mFieldF3285; }
    static void initFieldF3285 ()  { mFieldF3285 = new DataElement ("F3285",
            new  DataTypeValidatorString(0, 17,  new DataValueCodeListValidator(true, mCodeListF3285  ))  ); }

    static String[] mCodeListF3301 = null;
    static void initCodeListF3301 () { mCodeListF3301 =
            new String[] { "1","2","3","4","5" }; }
    static StructureItem mFieldF3301 = null;
    static StructureItem getFieldF3301() { initCodeListF3301(); if (mFieldF3301 == null) initFieldF3301(); return mFieldF3301; }
    static void initFieldF3301 ()  { mFieldF3301 = new DataElement ("F3301",
            new  DataTypeValidatorString(0, 17,  new DataValueCodeListValidator(true, mCodeListF3301  ))  ); }

    static StructureItem mFieldF3412 = null;
    static StructureItem getFieldF3412() {  if (mFieldF3412 == null) initFieldF3412(); return mFieldF3412; }
    static void initFieldF3412 ()  { mFieldF3412 = new DataElement ("F3412",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF3413 = null;
    static StructureItem getFieldF3413() {  if (mFieldF3413 == null) initFieldF3413(); return mFieldF3413; }
    static void initFieldF3413 ()  { mFieldF3413 = new DataElement ("F3413",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF3432 = null;
    static StructureItem getFieldF3432() {  if (mFieldF3432 == null) initFieldF3432(); return mFieldF3432; }
    static void initFieldF3432 ()  { mFieldF3432 = new DataElement ("F3432",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF3433 = null;
    static StructureItem getFieldF3433() {  if (mFieldF3433 == null) initFieldF3433(); return mFieldF3433; }
    static void initFieldF3433 ()  { mFieldF3433 = new DataElement ("F3433",
            new  DataTypeValidatorString(0, 11,  null  )  ); }

    static StructureItem mFieldF3434 = null;
    static StructureItem getFieldF3434() {  if (mFieldF3434 == null) initFieldF3434(); return mFieldF3434; }
    static void initFieldF3434 ()  { mFieldF3434 = new DataElement ("F3434",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF3436 = null;
    static StructureItem getFieldF3436() {  if (mFieldF3436 == null) initFieldF3436(); return mFieldF3436; }
    static void initFieldF3436 ()  { mFieldF3436 = new DataElement ("F3436",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF3446 = null;
    static StructureItem getFieldF3446() {  if (mFieldF3446 == null) initFieldF3446(); return mFieldF3446; }
    static void initFieldF3446 ()  { mFieldF3446 = new DataElement ("F3446",
            new  DataTypeValidatorString(0, 20,  null  )  ); }

    static StructureItem mFieldF3453 = null;
    static StructureItem getFieldF3453() {  if (mFieldF3453 == null) initFieldF3453(); return mFieldF3453; }
    static void initFieldF3453 ()  { mFieldF3453 = new DataElement ("F3453",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF4000 = null;
    static StructureItem getFieldF4000() {  if (mFieldF4000 == null) initFieldF4000(); return mFieldF4000; }
    static void initFieldF4000 ()  { mFieldF4000 = new DataElement ("F4000",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF4043 = null;
    static void initCodeListF4043 () { mCodeListF4043 =
            new String[] { "AG","BG","BR","CN","DE","DI","JB","MF","OE","RS","RT","ST","WH","WS" }; }
    static StructureItem mFieldF4043 = null;
    static StructureItem getFieldF4043() { initCodeListF4043(); if (mFieldF4043 == null) initFieldF4043(); return mFieldF4043; }
    static void initFieldF4043 ()  { mFieldF4043 = new DataElement ("F4043",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4043  ))  ); }

    static StructureItem mFieldF4052 = null;
    static StructureItem getFieldF4052() {  if (mFieldF4052 == null) initFieldF4052(); return mFieldF4052; }
    static void initFieldF4052 ()  { mFieldF4052 = new DataElement ("F4052",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF4053 = null;
    static StructureItem getFieldF4053() {  if (mFieldF4053 == null) initFieldF4053(); return mFieldF4053; }
    static void initFieldF4053 ()  { mFieldF4053 = new DataElement ("F4053",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static String[] mCodeListF4055 = null;
    static void initCodeListF4055 () { mCodeListF4055 =
            new String[] { "1","2","3","4","5","6" }; }
    static StructureItem mFieldF4055 = null;
    static StructureItem getFieldF4055() { initCodeListF4055(); if (mFieldF4055 == null) initFieldF4055(); return mFieldF4055; }
    static void initFieldF4055 ()  { mFieldF4055 = new DataElement ("F4055",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4055  ))  ); }

    static String[] mCodeListF4183 = null;
    static void initCodeListF4183 () { mCodeListF4183 =
            new String[] { "1","2","3","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100" }; }
    static StructureItem mFieldF4183 = null;
    static StructureItem getFieldF4183() { initCodeListF4183(); if (mFieldF4183 == null) initFieldF4183(); return mFieldF4183; }
    static void initFieldF4183 ()  { mFieldF4183 = new DataElement ("F4183",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4183  ))  ); }

    static String[] mCodeListF4215 = null;
    static void initCodeListF4215 () { mCodeListF4215 =
            new String[] { "A","CA","CC","CF","DF","FO","IC","MX","NC","NS","PA","PB","PC","PE","PO","PP","PU","RC","RF","RS","TP","WC","ZZZ" }; }
    static StructureItem mFieldF4215 = null;
    static StructureItem getFieldF4215() { initCodeListF4215(); if (mFieldF4215 == null) initFieldF4215(); return mFieldF4215; }
    static void initFieldF4215 ()  { mFieldF4215 = new DataElement ("F4215",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4215  ))  ); }

    static String[] mCodeListF4221 = null;
    static void initCodeListF4221 () { mCodeListF4221 =
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AN","AS","BK","BP","CA","CC","CE","CI","CK","CM","CN","CO","CP","CS","IC","IS","LS","NF","NN","NS","OF","OM","OP","OS","OW","PA","PD","PI","PK","PN","PO","PP","PS","RA","SL","SP","SS","TW","UR","ZZZ" }; }
    static StructureItem mFieldF4221 = null;
    static StructureItem getFieldF4221() { initCodeListF4221(); if (mFieldF4221 == null) initFieldF4221(); return mFieldF4221; }
    static void initFieldF4221 ()  { mFieldF4221 = new DataElement ("F4221",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4221  ))  ); }

    static String[] mCodeListF4233 = null;
    static void initCodeListF4233 () { mCodeListF4233 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","ZZZ" }; }
    static StructureItem mFieldF4233 = null;
    static StructureItem getFieldF4233() { initCodeListF4233(); if (mFieldF4233 == null) initFieldF4233(); return mFieldF4233; }
    static void initFieldF4233 ()  { mFieldF4233 = new DataElement ("F4233",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4233  ))  ); }

    static StructureItem mFieldF4276 = null;
    static StructureItem getFieldF4276() {  if (mFieldF4276 == null) initFieldF4276(); return mFieldF4276; }
    static void initFieldF4276 ()  { mFieldF4276 = new DataElement ("F4276",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF4277 = null;
    static void initCodeListF4277 () { mCodeListF4277 =
            new String[] { "1","2","3","4","5","6" }; }
    static StructureItem mFieldF4277 = null;
    static StructureItem getFieldF4277() { initCodeListF4277(); if (mFieldF4277 == null) initFieldF4277(); return mFieldF4277; }
    static void initFieldF4277 ()  { mFieldF4277 = new DataElement ("F4277",
            new  DataTypeValidatorString(0, 17,  new DataValueCodeListValidator(true, mCodeListF4277  ))  ); }

    static String[] mCodeListF4279 = null;
    static void initCodeListF4279 () { mCodeListF4279 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","ZZZ" }; }
    static StructureItem mFieldF4279 = null;
    static StructureItem getFieldF4279() { initCodeListF4279(); if (mFieldF4279 == null) initFieldF4279(); return mFieldF4279; }
    static void initFieldF4279 ()  { mFieldF4279 = new DataElement ("F4279",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4279  ))  ); }

    static StructureItem mFieldF4294 = null;
    static StructureItem getFieldF4294() {  if (mFieldF4294 == null) initFieldF4294(); return mFieldF4294; }
    static void initFieldF4294 ()  { mFieldF4294 = new DataElement ("F4294",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF4295 = null;
    static void initCodeListF4295 () { mCodeListF4295 =
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","BD","BQ","DC","EV","GU","GW","LD","MC","PC","PD","PQ","PS","PW","PZ","QO","QP","QT","SC","UM","UP","WD","WO","ZZZ" }; }
    static StructureItem mFieldF4295 = null;
    static StructureItem getFieldF4295() { initCodeListF4295(); if (mFieldF4295 == null) initFieldF4295(); return mFieldF4295; }
    static void initFieldF4295 ()  { mFieldF4295 = new DataElement ("F4295",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4295  ))  ); }

    static String[] mCodeListF4343 = null;
    static void initCodeListF4343 () { mCodeListF4343 =
            new String[] { "AA","AB","AC","AD","AF","AG","AI","AP","CA","CO","NA","RE" }; }
    static StructureItem mFieldF4343 = null;
    static StructureItem getFieldF4343() { initCodeListF4343(); if (mFieldF4343 == null) initFieldF4343(); return mFieldF4343; }
    static void initFieldF4343 ()  { mFieldF4343 = new DataElement ("F4343",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4343  ))  ); }

    static String[] mCodeListF4347 = null;
    static void initCodeListF4347 () { mCodeListF4347 =
            new String[] { "1","2","3","4","5","6","7","8" }; }
    static StructureItem mFieldF4347 = null;
    static StructureItem getFieldF4347() { initCodeListF4347(); if (mFieldF4347 == null) initFieldF4347(); return mFieldF4347; }
    static void initFieldF4347 ()  { mFieldF4347 = new DataElement ("F4347",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4347  ))  ); }

    static StructureItem mFieldF4400 = null;
    static StructureItem getFieldF4400() {  if (mFieldF4400 == null) initFieldF4400(); return mFieldF4400; }
    static void initFieldF4400 ()  { mFieldF4400 = new DataElement ("F4400",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF4401 = null;
    static void initCodeListF4401 () { mCodeListF4401 =
            new String[] { "AA","AB","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AP","AT","CO","DA","DB","DC","DD","DE","DF","DG","DH","DI","DJ","DK","DN","DO","DP","EI","EM","EX","QC","QE","RL","SW" }; }
    static StructureItem mFieldF4401 = null;
    static StructureItem getFieldF4401() { initCodeListF4401(); if (mFieldF4401 == null) initFieldF4401(); return mFieldF4401; }
    static void initFieldF4401 ()  { mFieldF4401 = new DataElement ("F4401",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4401  ))  ); }

    static String[] mCodeListF4403 = null;
    static void initCodeListF4403 () { mCodeListF4403 =
            new String[] { "1","2","3","4","5","6","7","8","9" }; }
    static StructureItem mFieldF4403 = null;
    static StructureItem getFieldF4403() { initCodeListF4403(); if (mFieldF4403 == null) initFieldF4403(); return mFieldF4403; }
    static void initFieldF4403 ()  { mFieldF4403 = new DataElement ("F4403",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4403  ))  ); }

    static String[] mCodeListF4405 = null;
    static void initCodeListF4405 () { mCodeListF4405 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21" }; }
    static StructureItem mFieldF4405 = null;
    static StructureItem getFieldF4405() { initCodeListF4405(); if (mFieldF4405 == null) initFieldF4405(); return mFieldF4405; }
    static void initFieldF4405 ()  { mFieldF4405 = new DataElement ("F4405",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4405  ))  ); }

    static String[] mCodeListF4431 = null;
    static void initCodeListF4431 () { mCodeListF4431 =
            new String[] { "1","10","11","12","13","14","20","21","23","24","41","44","45","ZZZ" }; }
    static StructureItem mFieldF4431 = null;
    static StructureItem getFieldF4431() { initCodeListF4431(); if (mFieldF4431 == null) initFieldF4431(); return mFieldF4431; }
    static void initFieldF4431 ()  { mFieldF4431 = new DataElement ("F4431",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4431  ))  ); }

    static String[] mCodeListF4435 = null;
    static void initCodeListF4435 () { mCodeListF4435 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","ZZZ" }; }
    static StructureItem mFieldF4435 = null;
    static StructureItem getFieldF4435() { initCodeListF4435(); if (mFieldF4435 == null) initFieldF4435(); return mFieldF4435; }
    static void initFieldF4435 ()  { mFieldF4435 = new DataElement ("F4435",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4435  ))  ); }

    static String[] mCodeListF4439 = null;
    static void initCodeListF4439 () { mCodeListF4439 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","61","62","63","64","69","70","71","ZZZ" }; }
    static StructureItem mFieldF4439 = null;
    static StructureItem getFieldF4439() { initCodeListF4439(); if (mFieldF4439 == null) initFieldF4439(); return mFieldF4439; }
    static void initFieldF4439 ()  { mFieldF4439 = new DataElement ("F4439",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4439  ))  ); }

    static StructureItem mFieldF4440 = null;
    static StructureItem getFieldF4440() {  if (mFieldF4440 == null) initFieldF4440(); return mFieldF4440; }
    static void initFieldF4440 ()  { mFieldF4440 = new DataElement ("F4440",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF4441 = null;
    static StructureItem getFieldF4441() {  if (mFieldF4441 == null) initFieldF4441(); return mFieldF4441; }
    static void initFieldF4441 ()  { mFieldF4441 = new DataElement ("F4441",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static String[] mCodeListF4451 = null;
    static void initCodeListF4451 () { mCodeListF4451 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ABO","ABP","ABQ","ABR","ABS","ABT","ABU","ABV","ABW","ABX","ABY","ABZ","ACA","ACB","ACC","ACD","ACE","ACF","ACG","ACH","ACI","ACJ","ACK","ACL","ACM","ACN","ACO","ACP","ACQ","ACR","ACS","ACT","ACU","ACV","ACW","ACX","ACY","ACZ","ADA","ADB","ADC","ADE","ADF","ADG","ADH","ADI","ADJ","ADK","ADL","ADM","ADN","ADO","ALC","ALL","ARR","AUT","BLC","BLR","CCI","CEX","CHG","CIP","CLP","CLR","COI","CUR","CUS","DAR","DCL","DEL","DIN","DOC","DUT","EUR","FBC","GBL","GEN","GS7","HAN","HAZ","ICN","IIN","IMI","IND","INS","INV","IRP","ITR","ITS","LIN","LOI","MCO","MKS","ORI","OSI","PAC","PAI","PAY","PKG","PKT","PMD","PMT","PRD","PRF","PRI","PUR","QIN","QQD","QUT","RAH","REG","RET","REV","RQR","RQT","SAF","SIC","SIN","SLR","SPA","SPG","SPH","SPP","SPT","SRN","SSR","SUR","TCA","TDT","TRA","TRR","TXD","WHI","ZZZ" }; }
    static StructureItem mFieldF4451 = null;
    static StructureItem getFieldF4451() { initCodeListF4451(); if (mFieldF4451 == null) initFieldF4451(); return mFieldF4451; }
    static void initFieldF4451 ()  { mFieldF4451 = new DataElement ("F4451",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4451  ))  ); }

    static String[] mCodeListF4453 = null;
    static void initCodeListF4453 () { mCodeListF4453 =
            new String[] { "1","2","3","4" }; }
    static StructureItem mFieldF4453 = null;
    static StructureItem getFieldF4453() { initCodeListF4453(); if (mFieldF4453 == null) initFieldF4453(); return mFieldF4453; }
    static void initFieldF4453 ()  { mFieldF4453 = new DataElement ("F4453",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4453  ))  ); }

    static String[] mCodeListF4461 = null;
    static void initCodeListF4461 () { mCodeListF4461 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","50","60","61","62","63","64","65","66","67","70","74","75","76","77","78","91","92","93","94","Used","ZZZ" }; }
    static StructureItem mFieldF4461 = null;
    static StructureItem getFieldF4461() { initCodeListF4461(); if (mFieldF4461 == null) initFieldF4461(); return mFieldF4461; }
    static void initFieldF4461 ()  { mFieldF4461 = new DataElement ("F4461",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4461  ))  ); }

    static String[] mCodeListF4465 = null;
    static void initCodeListF4465 () { mCodeListF4465 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","ZZZ" }; }
    static StructureItem mFieldF4465 = null;
    static StructureItem getFieldF4465() { initCodeListF4465(); if (mFieldF4465 == null) initFieldF4465(); return mFieldF4465; }
    static void initFieldF4465 ()  { mFieldF4465 = new DataElement ("F4465",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4465  ))  ); }

    static String[] mCodeListF4471 = null;
    static void initCodeListF4471 () { mCodeListF4471 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","ZZZ" }; }
    static StructureItem mFieldF4471 = null;
    static StructureItem getFieldF4471() { initCodeListF4471(); if (mFieldF4471 == null) initFieldF4471(); return mFieldF4471; }
    static void initFieldF4471 ()  { mFieldF4471 = new DataElement ("F4471",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4471  ))  ); }

    static StructureItem mFieldF5004 = null;
    static StructureItem getFieldF5004() {  if (mFieldF5004 == null) initFieldF5004(); return mFieldF5004; }
    static void initFieldF5004 ()  { mFieldF5004 = new DataElement ("F5004",
            new  DataTypeValidatorDecimal(0, 18, 0)  ); }

    static String[] mCodeListF5025 = null;
    static void initCodeListF5025 () { mCodeListF5025 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","220","221","222","223","224","225","226","227","228","229","230","231","232","233","234","235","236","237","238","239","240","241","242","243","244","245","246","247","248","249","250","251","252","253","254","255","256","257","258","259","260","261","262","263","264","265","266","267","268","269","270","271","272","273","274","275","276","277","278","279","280","281","282","283","284","285","286","287","288","289","290","291","292","293","294","295","296","297","298","299","300","301","302","303","304","305","306","307","308","309","310","311","312","313","314","315","316","317","318","319","320","321","322","323","324","325","326","327","328","329","330","331","332","333","334","335","336","ZZZ" }; }
    static StructureItem mFieldF5025 = null;
    static StructureItem getFieldF5025() { initCodeListF5025(); if (mFieldF5025 == null) initFieldF5025(); return mFieldF5025; }
    static void initFieldF5025 ()  { mFieldF5025 = new DataElement ("F5025",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5025  ))  ); }

    static StructureItem mFieldF5118 = null;
    static StructureItem getFieldF5118() {  if (mFieldF5118 == null) initFieldF5118(); return mFieldF5118; }
    static void initFieldF5118 ()  { mFieldF5118 = new DataElement ("F5118",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static String[] mCodeListF5125 = null;
    static void initCodeListF5125 () { mCodeListF5125 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAF","CAL","INF","INV" }; }
    static StructureItem mFieldF5125 = null;
    static StructureItem getFieldF5125() { initCodeListF5125(); if (mFieldF5125 == null) initFieldF5125(); return mFieldF5125; }
    static void initFieldF5125 ()  { mFieldF5125 = new DataElement ("F5125",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5125  ))  ); }

    static StructureItem mFieldF5152 = null;
    static StructureItem getFieldF5152() {  if (mFieldF5152 == null) initFieldF5152(); return mFieldF5152; }
    static void initFieldF5152 ()  { mFieldF5152 = new DataElement ("F5152",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF5153 = null;
    static void initCodeListF5153 () { mCodeListF5153 =
            new String[] { "AAA","AAB","AAC","ADD","BOL","CAP","CAR","COC","CST","CUD","CVD","ENV","EXC","EXP","FET","FRE","GCN","GST","ILL","IMP","IND","LAC","LCN","LDP","LOC","LST","MCA","MCD","OTH","PDB","PDC","PRF","SCN","SSS","STT","SUP","SUR","SWT","TAC","TOT","TOX","TTA","VAD","VAT" }; }
    static StructureItem mFieldF5153 = null;
    static StructureItem getFieldF5153() { initCodeListF5153(); if (mFieldF5153 == null) initFieldF5153(); return mFieldF5153; }
    static void initFieldF5153 ()  { mFieldF5153 = new DataElement ("F5153",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5153  ))  ); }

    static String[] mCodeListF5189 = null;
    static void initCodeListF5189 () { mCodeListF5189 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53" }; }
    static StructureItem mFieldF5189 = null;
    static StructureItem getFieldF5189() { initCodeListF5189(); if (mFieldF5189 == null) initFieldF5189(); return mFieldF5189; }
    static void initFieldF5189 ()  { mFieldF5189 = new DataElement ("F5189",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5189  ))  ); }

    static String[] mCodeListF5213 = null;
    static void initCodeListF5213 () { mCodeListF5213 =
            new String[] { "A","I","S" }; }
    static StructureItem mFieldF5213 = null;
    static StructureItem getFieldF5213() { initCodeListF5213(); if (mFieldF5213 == null) initFieldF5213(); return mFieldF5213; }
    static void initFieldF5213 ()  { mFieldF5213 = new DataElement ("F5213",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5213  ))  ); }

    static String[] mCodeListF5245 = null;
    static void initCodeListF5245 () { mCodeListF5245 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44" }; }
    static StructureItem mFieldF5245 = null;
    static StructureItem getFieldF5245() { initCodeListF5245(); if (mFieldF5245 == null) initFieldF5245(); return mFieldF5245; }
    static void initFieldF5245 ()  { mFieldF5245 = new DataElement ("F5245",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5245  ))  ); }

    static String[] mCodeListF5249 = null;
    static void initCodeListF5249 () { mCodeListF5249 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14" }; }
    static StructureItem mFieldF5249 = null;
    static StructureItem getFieldF5249() { initCodeListF5249(); if (mFieldF5249 == null) initFieldF5249(); return mFieldF5249; }
    static void initFieldF5249 ()  { mFieldF5249 = new DataElement ("F5249",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5249  ))  ); }

    static String[] mCodeListF5273 = null;
    static void initCodeListF5273 () { mCodeListF5273 =
            new String[] { "1","2","3" }; }
    static StructureItem mFieldF5273 = null;
    static StructureItem getFieldF5273() { initCodeListF5273(); if (mFieldF5273 == null) initFieldF5273(); return mFieldF5273; }
    static void initFieldF5273 ()  { mFieldF5273 = new DataElement ("F5273",
            new  DataTypeValidatorString(0, 12,  new DataValueCodeListValidator(true, mCodeListF5273  ))  ); }

    static StructureItem mFieldF5278 = null;
    static StructureItem getFieldF5278() {  if (mFieldF5278 == null) initFieldF5278(); return mFieldF5278; }
    static void initFieldF5278 ()  { mFieldF5278 = new DataElement ("F5278",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF5279 = null;
    static StructureItem getFieldF5279() {  if (mFieldF5279 == null) initFieldF5279(); return mFieldF5279; }
    static void initFieldF5279 ()  { mFieldF5279 = new DataElement ("F5279",
            new  DataTypeValidatorString(0, 7,  null  )  ); }

    static String[] mCodeListF5283 = null;
    static void initCodeListF5283 () { mCodeListF5283 =
            new String[] { "1","2","3","4","5","6","7","9" }; }
    static StructureItem mFieldF5283 = null;
    static StructureItem getFieldF5283() { initCodeListF5283(); if (mFieldF5283 == null) initFieldF5283(); return mFieldF5283; }
    static void initFieldF5283 ()  { mFieldF5283 = new DataElement ("F5283",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5283  ))  ); }

    static StructureItem mFieldF5284 = null;
    static StructureItem getFieldF5284() {  if (mFieldF5284 == null) initFieldF5284(); return mFieldF5284; }
    static void initFieldF5284 ()  { mFieldF5284 = new DataElement ("F5284",
            new  DataTypeValidatorDecimal(0, 9, 0)  ); }

    static StructureItem mFieldF5286 = null;
    static StructureItem getFieldF5286() {  if (mFieldF5286 == null) initFieldF5286(); return mFieldF5286; }
    static void initFieldF5286 ()  { mFieldF5286 = new DataElement ("F5286",
            new  DataTypeValidatorString(0, 15,  null  )  ); }

    static StructureItem mFieldF5289 = null;
    static StructureItem getFieldF5289() {  if (mFieldF5289 == null) initFieldF5289(); return mFieldF5289; }
    static void initFieldF5289 ()  { mFieldF5289 = new DataElement ("F5289",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static String[] mCodeListF5305 = null;
    static void initCodeListF5305 () { mCodeListF5305 =
            new String[] { "A","B","C","E","G","H","O","S","Z" }; }
    static StructureItem mFieldF5305 = null;
    static StructureItem getFieldF5305() { initCodeListF5305(); if (mFieldF5305 == null) initFieldF5305(); return mFieldF5305; }
    static void initFieldF5305 ()  { mFieldF5305 = new DataElement ("F5305",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5305  ))  ); }

    static String[] mCodeListF5375 = null;
    static void initCodeListF5375 () { mCodeListF5375 =
            new String[] { "AA","AB","AC","AD","AE","AI","AQ","CA","CT","CU","DI","EC","NW","PC","PE","PK","PL","PT","PU","PV","PW","QT","SR","TB","TU","TW","WH" }; }
    static StructureItem mFieldF5375 = null;
    static StructureItem getFieldF5375() { initCodeListF5375(); if (mFieldF5375 == null) initFieldF5375(); return mFieldF5375; }
    static void initFieldF5375 ()  { mFieldF5375 = new DataElement ("F5375",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5375  ))  ); }

    static String[] mCodeListF5387 = null;
    static void initCodeListF5387 () { mCodeListF5387 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABF","AI","ALT","AP","BR","CAT","CDV","CON","CP","CU","CUP","CUS","DAP","DIS","DPR","DR","DSC","EC","ES","EUP","FCR","GRP","INV","LBL","MAX","MIN","MNR","MSR","MXR","NE","NQT","NTP","NW","OCR","OFR","PAQ","PBQ","PPD","PPR","PRO","PRP","PW","QTE","RES","RTP","SHD","SRP","SW","TB","TRF","TU","TW","WH" }; }
    static StructureItem mFieldF5387 = null;
    static StructureItem getFieldF5387() { initCodeListF5387(); if (mFieldF5387 == null) initFieldF5387(); return mFieldF5387; }
    static void initFieldF5387 ()  { mFieldF5387 = new DataElement ("F5387",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5387  ))  ); }

    static String[] mCodeListF5393 = null;
    static void initCodeListF5393 () { mCodeListF5393 =
            new String[] { "A","B","C","CSD","CSR","DIS","SEL" }; }
    static StructureItem mFieldF5393 = null;
    static StructureItem getFieldF5393() { initCodeListF5393(); if (mFieldF5393 == null) initFieldF5393(); return mFieldF5393; }
    static void initFieldF5393 ()  { mFieldF5393 = new DataElement ("F5393",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5393  ))  ); }

    static StructureItem mFieldF5394 = null;
    static StructureItem getFieldF5394() {  if (mFieldF5394 == null) initFieldF5394(); return mFieldF5394; }
    static void initFieldF5394 ()  { mFieldF5394 = new DataElement ("F5394",
            new  DataTypeValidatorDecimal(0, 12, 0)  ); }

    static StructureItem mFieldF5402 = null;
    static StructureItem getFieldF5402() {  if (mFieldF5402 == null) initFieldF5402(); return mFieldF5402; }
    static void initFieldF5402 ()  { mFieldF5402 = new DataElement ("F5402",
            new  DataTypeValidatorDecimal(0, 12, 0)  ); }

    static String[] mCodeListF5419 = null;
    static void initCodeListF5419 () { mCodeListF5419 =
            new String[] { "1","2","3" }; }
    static StructureItem mFieldF5419 = null;
    static StructureItem getFieldF5419() { initCodeListF5419(); if (mFieldF5419 == null) initFieldF5419(); return mFieldF5419; }
    static void initFieldF5419 ()  { mFieldF5419 = new DataElement ("F5419",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5419  ))  ); }

    static StructureItem mFieldF5420 = null;
    static StructureItem getFieldF5420() {  if (mFieldF5420 == null) initFieldF5420(); return mFieldF5420; }
    static void initFieldF5420 ()  { mFieldF5420 = new DataElement ("F5420",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static String[] mCodeListF5463 = null;
    static void initCodeListF5463 () { mCodeListF5463 =
            new String[] { "A","B","C","D","E","F","G","H","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y" }; }
    static StructureItem mFieldF5463 = null;
    static StructureItem getFieldF5463() { initCodeListF5463(); if (mFieldF5463 == null) initFieldF5463(); return mFieldF5463; }
    static void initFieldF5463 ()  { mFieldF5463 = new DataElement ("F5463",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5463  ))  ); }

    static StructureItem mFieldF5479 = null;
    static StructureItem getFieldF5479() {  if (mFieldF5479 == null) initFieldF5479(); return mFieldF5479; }
    static void initFieldF5479 ()  { mFieldF5479 = new DataElement ("F5479",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF5482 = null;
    static StructureItem getFieldF5482() {  if (mFieldF5482 == null) initFieldF5482(); return mFieldF5482; }
    static void initFieldF5482 ()  { mFieldF5482 = new DataElement ("F5482",
            new  DataTypeValidatorDecimal(0, 10, 0)  ); }

    static String[] mCodeListF5495 = null;
    static void initCodeListF5495 () { mCodeListF5495 =
            new String[] { "1" }; }
    static StructureItem mFieldF5495 = null;
    static StructureItem getFieldF5495() { initCodeListF5495(); if (mFieldF5495 == null) initFieldF5495(); return mFieldF5495; }
    static void initFieldF5495 ()  { mFieldF5495 = new DataElement ("F5495",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5495  ))  ); }

    static StructureItem mFieldF6060 = null;
    static StructureItem getFieldF6060() {  if (mFieldF6060 == null) initFieldF6060(); return mFieldF6060; }
    static void initFieldF6060 ()  { mFieldF6060 = new DataElement ("F6060",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static String[] mCodeListF6063 = null;
    static void initCodeListF6063 () { mCodeListF6063 =
            new String[] { "1","2","3","8","11","12","17","18","20","21","22","23","24","25","26","27","28","29","30","31","32","33","35","36","40","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200" }; }
    static StructureItem mFieldF6063 = null;
    static StructureItem getFieldF6063() { initCodeListF6063(); if (mFieldF6063 == null) initFieldF6063(); return mFieldF6063; }
    static void initFieldF6063 ()  { mFieldF6063 = new DataElement ("F6063",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6063  ))  ); }

    static StructureItem mFieldF6064 = null;
    static StructureItem getFieldF6064() {  if (mFieldF6064 == null) initFieldF6064(); return mFieldF6064; }
    static void initFieldF6064 ()  { mFieldF6064 = new DataElement ("F6064",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static StructureItem mFieldF6066 = null;
    static StructureItem getFieldF6066() {  if (mFieldF6066 == null) initFieldF6066(); return mFieldF6066; }
    static void initFieldF6066 ()  { mFieldF6066 = new DataElement ("F6066",
            new  DataTypeValidatorDecimal(0, 18, 0)  ); }

    static String[] mCodeListF6069 = null;
    static void initCodeListF6069 () { mCodeListF6069 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31" }; }
    static StructureItem mFieldF6069 = null;
    static StructureItem getFieldF6069() { initCodeListF6069(); if (mFieldF6069 == null) initFieldF6069(); return mFieldF6069; }
    static void initFieldF6069 ()  { mFieldF6069 = new DataElement ("F6069",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6069  ))  ); }

    static StructureItem mFieldF6152 = null;
    static StructureItem getFieldF6152() {  if (mFieldF6152 == null) initFieldF6152(); return mFieldF6152; }
    static void initFieldF6152 ()  { mFieldF6152 = new DataElement ("F6152",
            new  DataTypeValidatorDecimal(0, 18, 0)  ); }

    static StructureItem mFieldF6154 = null;
    static StructureItem getFieldF6154() {  if (mFieldF6154 == null) initFieldF6154(); return mFieldF6154; }
    static void initFieldF6154 ()  { mFieldF6154 = new DataElement ("F6154",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static String[] mCodeListF6155 = null;
    static void initCodeListF6155 () { mCodeListF6155 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","18","19","20","21","22","23","24","25","26","27","28","29","32","33","34","35","36","37","38","39","40","41","42","43","44","45" }; }
    static StructureItem mFieldF6155 = null;
    static StructureItem getFieldF6155() { initCodeListF6155(); if (mFieldF6155 == null) initFieldF6155(); return mFieldF6155; }
    static void initFieldF6155 ()  { mFieldF6155 = new DataElement ("F6155",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6155  ))  ); }

    static StructureItem mFieldF6162 = null;
    static StructureItem getFieldF6162() {  if (mFieldF6162 == null) initFieldF6162(); return mFieldF6162; }
    static void initFieldF6162 ()  { mFieldF6162 = new DataElement ("F6162",
            new  DataTypeValidatorDecimal(0, 18, 0)  ); }

    static String[] mCodeListF6167 = null;
    static void initCodeListF6167 () { mCodeListF6167 =
            new String[] { "1","2","3","4","5","6","7","8","9","10" }; }
    static StructureItem mFieldF6167 = null;
    static StructureItem getFieldF6167() { initCodeListF6167(); if (mFieldF6167 == null) initFieldF6167(); return mFieldF6167; }
    static void initFieldF6167 ()  { mFieldF6167 = new DataElement ("F6167",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6167  ))  ); }

    static String[] mCodeListF6311 = null;
    static void initCodeListF6311 () { mCodeListF6311 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ASW","CH","CHW","CN","CS","CT","DEN","DR","DT","DV","DX","EGW","EN","EVO","FO","IV","LAO","LC","LGL","LL","LMT","NAX","PAL","PC","PD","PL","PLL","RL","RN","SE","SH","SM","SO","SPG","SR","ST","SU","SV","TE","TL","TR","TX","VO","VOL","VT","WT","WX" }; }
    static StructureItem mFieldF6311 = null;
    static StructureItem getFieldF6311() { initCodeListF6311(); if (mFieldF6311 == null) initFieldF6311(); return mFieldF6311; }
    static void initFieldF6311 ()  { mFieldF6311 = new DataElement ("F6311",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6311  ))  ); }

    static String[] mCodeListF6313 = null;
    static void initCodeListF6313 () { mCodeListF6313 =
            new String[] { "A","AAA","AAB","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ABO","ABQ","ABR","ABS","ABU","ABV","ABW","ABX","ABY","ABZ","ACA","ACB","ACC","ACD","ACE","ACF","ACG","ACH","ACI","ACJ","ACK","ACL","ACM","ACN","ACO","ACP","ACQ","ACR","ACS","ACT","ACU","ACV","ACW","ACX","ACY","ACZ","ADA","ADB","ADC","ADD","ADE","ADF","ADG","ADH","ADI","ADJ","ADK","ADL","ADM","ADN","ADO","ADP","ADQ","ADR","ADS","ADT","ADU","ADV","ADW","ADX","ADY","ADZ","AEA","AEB","AEC","AED","AEE","AEF","AEG","AEH","AF","B","BL","BND","BR","BRA","BRE","BS","BSW","BW","CHN","CM","CT","CV","CZ","D","DI","DL","DN","DP","DR","DS","DW","E","EA","F","FI","FL","FN","FV","G","GG","GW","HF","HM","HT","IB","ID","L","LM","LN","LND","M","MO","MW","N","OD","PRS","PTN","RA","RF","RJ","RMW","RP","RUN","RY","SQ","T","TC","TH","TN","TT","U","VH","VW","WA","WD","WM","WT","WU","XH","XQ","XZ","YS","ZAL","ZAS","ZB","ZBI","ZC","ZCA","ZCB","ZCE","ZCL","ZCO","ZCR","ZCU","ZFE","ZFS","ZGE","ZH","ZK","ZMG","ZMN","ZMO","ZN","ZNA","ZNB","ZNI","ZO","ZP","ZPB","ZS","ZSB","ZSE","ZSI","ZSL","ZSN","ZTA","ZTE","ZTI","ZV","ZW","ZWA","ZZN","ZZR","ZZZ" }; }
    static StructureItem mFieldF6313 = null;
    static StructureItem getFieldF6313() { initCodeListF6313(); if (mFieldF6313 == null) initFieldF6313(); return mFieldF6313; }
    static void initFieldF6313 ()  { mFieldF6313 = new DataElement ("F6313",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6313  ))  ); }

    static StructureItem mFieldF6314 = null;
    static StructureItem getFieldF6314() {  if (mFieldF6314 == null) initFieldF6314(); return mFieldF6314; }
    static void initFieldF6314 ()  { mFieldF6314 = new DataElement ("F6314",
            new  DataTypeValidatorDecimal(0, 18, 0)  ); }

    static String[] mCodeListF6321 = null;
    static void initCodeListF6321 () { mCodeListF6321 =
            new String[] { "3","4","5","6","7","8","10","11","12","13","15" }; }
    static StructureItem mFieldF6321 = null;
    static StructureItem getFieldF6321() { initCodeListF6321(); if (mFieldF6321 == null) initFieldF6321(); return mFieldF6321; }
    static void initFieldF6321 ()  { mFieldF6321 = new DataElement ("F6321",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6321  ))  ); }

    static String[] mCodeListF6341 = null;
    static void initCodeListF6341 () { mCodeListF6341 =
            new String[] { "AAA","AMS","ARG","AST","AUS","BEL","CAN","CAR","CIE","DEN","ECR","FIN","FRA","IMF","LNF","LNS","MIL","NOR","NYC","PHI","SRE","SWE","ZUR" }; }
    static StructureItem mFieldF6341 = null;
    static StructureItem getFieldF6341() { initCodeListF6341(); if (mFieldF6341 == null) initFieldF6341(); return mFieldF6341; }
    static void initFieldF6341 ()  { mFieldF6341 = new DataElement ("F6341",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6341  ))  ); }

    static String[] mCodeListF6343 = null;
    static void initCodeListF6343 () { mCodeListF6343 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17" }; }
    static StructureItem mFieldF6343 = null;
    static StructureItem getFieldF6343() { initCodeListF6343(); if (mFieldF6343 == null) initFieldF6343(); return mFieldF6343; }
    static void initFieldF6343 ()  { mFieldF6343 = new DataElement ("F6343",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6343  ))  ); }

    static StructureItem mFieldF6345 = null;
    static StructureItem getFieldF6345() {  if (mFieldF6345 == null) initFieldF6345(); return mFieldF6345; }
    static void initFieldF6345 ()  { mFieldF6345 = new DataElement ("F6345",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static String[] mCodeListF6347 = null;
    static void initCodeListF6347 () { mCodeListF6347 =
            new String[] { "1","2","3","4","5","6","7" }; }
    static StructureItem mFieldF6347 = null;
    static StructureItem getFieldF6347() { initCodeListF6347(); if (mFieldF6347 == null) initFieldF6347(); return mFieldF6347; }
    static void initFieldF6347 ()  { mFieldF6347 = new DataElement ("F6347",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6347  ))  ); }

    static StructureItem mFieldF6348 = null;
    static StructureItem getFieldF6348() {  if (mFieldF6348 == null) initFieldF6348(); return mFieldF6348; }
    static void initFieldF6348 ()  { mFieldF6348 = new DataElement ("F6348",
            new  DataTypeValidatorDecimal(0, 4, 0)  ); }

    static StructureItem mFieldF6411 = null;
    static StructureItem getFieldF6411() {  if (mFieldF6411 == null) initFieldF6411(); return mFieldF6411; }
    static void initFieldF6411 ()  { mFieldF6411 = new DataElement ("F6411",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF6432 = null;
    static StructureItem getFieldF6432() {  if (mFieldF6432 == null) initFieldF6432(); return mFieldF6432; }
    static void initFieldF6432 ()  { mFieldF6432 = new DataElement ("F6432",
            new  DataTypeValidatorDecimal(0, 2, 0)  ); }

    static StructureItem mFieldF7008 = null;
    static StructureItem getFieldF7008() {  if (mFieldF7008 == null) initFieldF7008(); return mFieldF7008; }
    static void initFieldF7008 ()  { mFieldF7008 = new DataElement ("F7008",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF7009 = null;
    static StructureItem getFieldF7009() {  if (mFieldF7009 == null) initFieldF7009(); return mFieldF7009; }
    static void initFieldF7009 ()  { mFieldF7009 = new DataElement ("F7009",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF7064 = null;
    static StructureItem getFieldF7064() {  if (mFieldF7064 == null) initFieldF7064(); return mFieldF7064; }
    static void initFieldF7064 ()  { mFieldF7064 = new DataElement ("F7064",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF7065 = null;
    static StructureItem getFieldF7065() {  if (mFieldF7065 == null) initFieldF7065(); return mFieldF7065; }
    static void initFieldF7065 ()  { mFieldF7065 = new DataElement ("F7065",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF7073 = null;
    static void initCodeListF7073 () { mCodeListF7073 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23" }; }
    static StructureItem mFieldF7073 = null;
    static StructureItem getFieldF7073() { initCodeListF7073(); if (mFieldF7073 == null) initFieldF7073(); return mFieldF7073; }
    static void initFieldF7073 ()  { mFieldF7073 = new DataElement ("F7073",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7073  ))  ); }

    static String[] mCodeListF7075 = null;
    static void initCodeListF7075 () { mCodeListF7075 =
            new String[] { "1","2","3","4" }; }
    static StructureItem mFieldF7075 = null;
    static StructureItem getFieldF7075() { initCodeListF7075(); if (mFieldF7075 == null) initFieldF7075(); return mFieldF7075; }
    static void initFieldF7075 ()  { mFieldF7075 = new DataElement ("F7075",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7075  ))  ); }

    static String[] mCodeListF7077 = null;
    static void initCodeListF7077 () { mCodeListF7077 =
            new String[] { "A","B","C","D","E","F","S","X" }; }
    static StructureItem mFieldF7077 = null;
    static StructureItem getFieldF7077() { initCodeListF7077(); if (mFieldF7077 == null) initFieldF7077(); return mFieldF7077; }
    static void initFieldF7077 ()  { mFieldF7077 = new DataElement ("F7077",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7077  ))  ); }

    static String[] mCodeListF7081 = null;
    static void initCodeListF7081 () { mCodeListF7081 =
            new String[] { "1","2","3","4","5","8","9","11","12","13","14","15","17","18","19","21","22","23","24","25","26","28","30","32","35","38","43","54","56","58","59","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98" }; }
    static StructureItem mFieldF7081 = null;
    static StructureItem getFieldF7081() { initCodeListF7081(); if (mFieldF7081 == null) initFieldF7081(); return mFieldF7081; }
    static void initFieldF7081 ()  { mFieldF7081 = new DataElement ("F7081",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7081  ))  ); }

    static String[] mCodeListF7083 = null;
    static void initCodeListF7083 () { mCodeListF7083 =
            new String[] { "A","D","I" }; }
    static StructureItem mFieldF7083 = null;
    static StructureItem getFieldF7083() { initCodeListF7083(); if (mFieldF7083 == null) initFieldF7083(); return mFieldF7083; }
    static void initFieldF7083 ()  { mFieldF7083 = new DataElement ("F7083",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7083  ))  ); }

    static StructureItem mFieldF7102 = null;
    static StructureItem getFieldF7102() {  if (mFieldF7102 == null) initFieldF7102(); return mFieldF7102; }
    static void initFieldF7102 ()  { mFieldF7102 = new DataElement ("F7102",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF7130 = null;
    static StructureItem getFieldF7130() {  if (mFieldF7130 == null) initFieldF7130(); return mFieldF7130; }
    static void initFieldF7130 ()  { mFieldF7130 = new DataElement ("F7130",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF7140 = null;
    static StructureItem getFieldF7140() {  if (mFieldF7140 == null) initFieldF7140(); return mFieldF7140; }
    static void initFieldF7140 ()  { mFieldF7140 = new DataElement ("F7140",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF7143 = null;
    static void initCodeListF7143 () { mCodeListF7143 =
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AT","AU","BO","BP","CC","CG","CL","CR","CV","DR","DW","EC","EF","EN","GB","GN","GS","HS","IB","IN","IS","IT","IZ","MA","MF","MN","MP","NB","ON","PD","PL","PO","PV","QS","RC","RN","RU","RY","SA","SG","SK","SN","SRS","SS","ST","TG","UA","UP","VN","VP","VS","VX","ZZZ" }; }
    static StructureItem mFieldF7143 = null;
    static StructureItem getFieldF7143() { initCodeListF7143(); if (mFieldF7143 == null) initFieldF7143(); return mFieldF7143; }
    static void initFieldF7143 ()  { mFieldF7143 = new DataElement ("F7143",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7143  ))  ); }

    static StructureItem mFieldF7160 = null;
    static StructureItem getFieldF7160() {  if (mFieldF7160 == null) initFieldF7160(); return mFieldF7160; }
    static void initFieldF7160 ()  { mFieldF7160 = new DataElement ("F7160",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF7161 = null;
    static void initCodeListF7161 () { mCodeListF7161 =
            new String[] { "AA","AAA","AAB","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ABO","ABP","ABQ","ABR","ABS","ABT","ABU","ABV","ABW","ABX","ABY","ABZ","ACA","ACB","ACC","ACD","ACE","ACF","ACG","ACH","ACI","ACJ","ACK","ACL","ACM","ACN","ACO","ACP","ACQ","ACR","ACS","ACT","ACU","ACV","ACW","ACX","ACY","ACZ","ADA","ADB","ADC","ADD","ADE","ADF","ADG","ADH","ADI","ADJ","ADK","ADL","ADM","ADN","ADO","ADP","ADQ","ADR","ADS","ADT","AG","AJ","AL","AM","AU","CA","CAA","CAB","CAC","CAD","CAE","CAF","CAG","CAH","CAI","CAJ","CAK","CB","CD","CG","CK","CL","CO","CP","CS","CT","CW","DA","DAA","DAB","DAD","DAE","DI","DL","DM","EAA","EAB","EG","EP","ER","EX","FA","FAA","FAB","FAC","FC","FG","FH","FI","FN","FR","GAA","HAA","HD","HH","IA","IAA","IAB","ID","IF","IN","IR","IS","KO","L1","LA","LAA","LAB","LAC","LF","LS","MA","MAA","MAB","MAC","MAD","MAE","MC","MI","ML","NAA","OA","OAA","PA","PAA","PAB","PAC","PAD","PAE","PC","PD","PI","PL","PN","PO","QAA","QD","RAA","RAB","RAC","RAD","RAE","RAF","RAG","RAH","RE","RF","RH","RO","RP","RV","SA","SAA","SAB","SAC","SAD","SAE","SAF","SAG","SAH","SAI","SAJ","SC","SD","SF","SG","SH","SM","ST","SU","SZ","TAA","TAB","TAC","TAD","TAE","TD","TS","TT","TV","TX","TZ","UM","V1","V2","VAA","VAB","VL","WH","XAA","YY","ZZZ" }; }
    static StructureItem mFieldF7161 = null;
    static StructureItem getFieldF7161() { initCodeListF7161(); if (mFieldF7161 == null) initFieldF7161(); return mFieldF7161; }
    static void initFieldF7161 ()  { mFieldF7161 = new DataElement ("F7161",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7161  ))  ); }

    static StructureItem mFieldF7224 = null;
    static StructureItem getFieldF7224() {  if (mFieldF7224 == null) initFieldF7224(); return mFieldF7224; }
    static void initFieldF7224 ()  { mFieldF7224 = new DataElement ("F7224",
            new  DataTypeValidatorDecimal(0, 8, 0)  ); }

    static String[] mCodeListF7233 = null;
    static void initCodeListF7233 () { mCodeListF7233 =
            new String[] { "34","35","36","37","38","39","40","41","42","43","44","45","50","51","52","53","54","60","61","62","63","66","67","68","69" }; }
    static StructureItem mFieldF7233 = null;
    static StructureItem getFieldF7233() { initCodeListF7233(); if (mFieldF7233 == null) initFieldF7233(); return mFieldF7233; }
    static void initFieldF7233 ()  { mFieldF7233 = new DataElement ("F7233",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7233  ))  ); }

    static String[] mCodeListF7293 = null;
    static void initCodeListF7293 () { mCodeListF7293 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13" }; }
    static StructureItem mFieldF7293 = null;
    static StructureItem getFieldF7293() { initCodeListF7293(); if (mFieldF7293 == null) initFieldF7293(); return mFieldF7293; }
    static void initFieldF7293 ()  { mFieldF7293 = new DataElement ("F7293",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7293  ))  ); }

    static StructureItem mFieldF7294 = null;
    static StructureItem getFieldF7294() {  if (mFieldF7294 == null) initFieldF7294(); return mFieldF7294; }
    static void initFieldF7294 ()  { mFieldF7294 = new DataElement ("F7294",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF7295 = null;
    static StructureItem getFieldF7295() {  if (mFieldF7295 == null) initFieldF7295(); return mFieldF7295; }
    static void initFieldF7295 ()  { mFieldF7295 = new DataElement ("F7295",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF7297 = null;
    static void initCodeListF7297 () { mCodeListF7297 =
            new String[] { "1","2","3","4","5","6","7","8","9" }; }
    static StructureItem mFieldF7297 = null;
    static StructureItem getFieldF7297() { initCodeListF7297(); if (mFieldF7297 == null) initFieldF7297(); return mFieldF7297; }
    static void initFieldF7297 ()  { mFieldF7297 = new DataElement ("F7297",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7297  ))  ); }

    static String[] mCodeListF7383 = null;
    static void initCodeListF7383 () { mCodeListF7383 =
            new String[] { "1S","2S","AA","AB","AC","BC","BS","BT","DF","FR","IN","LE","OA","OS","OT","RI","RR","ST","TB","TP","TS","UC" }; }
    static StructureItem mFieldF7383 = null;
    static StructureItem getFieldF7383() { initCodeListF7383(); if (mFieldF7383 == null) initFieldF7383(); return mFieldF7383; }
    static void initFieldF7383 ()  { mFieldF7383 = new DataElement ("F7383",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7383  ))  ); }

    static StructureItem mFieldF7402 = null;
    static StructureItem getFieldF7402() {  if (mFieldF7402 == null) initFieldF7402(); return mFieldF7402; }
    static void initFieldF7402 ()  { mFieldF7402 = new DataElement ("F7402",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF7405 = null;
    static void initCodeListF7405 () { mCodeListF7405 =
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","AZ","BA","BB","BC","BD","BE","BF","BG","BH","BI","BJ","BK","BL","BN","BX","CN","EE","EM","IL","ML","PN","SC","VV" }; }
    static StructureItem mFieldF7405 = null;
    static StructureItem getFieldF7405() { initCodeListF7405(); if (mFieldF7405 == null) initFieldF7405(); return mFieldF7405; }
    static void initFieldF7405 ()  { mFieldF7405 = new DataElement ("F7405",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7405  ))  ); }

    static StructureItem mFieldF7511 = null;
    static StructureItem getFieldF7511() {  if (mFieldF7511 == null) initFieldF7511(); return mFieldF7511; }
    static void initFieldF7511 ()  { mFieldF7511 = new DataElement ("F7511",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF8028 = null;
    static StructureItem getFieldF8028() {  if (mFieldF8028 == null) initFieldF8028(); return mFieldF8028; }
    static void initFieldF8028 ()  { mFieldF8028 = new DataElement ("F8028",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF8051 = null;
    static void initCodeListF8051 () { mCodeListF8051 =
            new String[] { "1","2","10","11","12","13","14","20","21","22","23","24","25","30" }; }
    static StructureItem mFieldF8051 = null;
    static StructureItem getFieldF8051() { initCodeListF8051(); if (mFieldF8051 == null) initFieldF8051(); return mFieldF8051; }
    static void initFieldF8051 ()  { mFieldF8051 = new DataElement ("F8051",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8051  ))  ); }

    static String[] mCodeListF8053 = null;
    static void initCodeListF8053 () { mCodeListF8053 =
            new String[] { "AA","AB","AD","AE","BL","BPN","BPY","BR","BX","CH","CN","DPA","EFP","EYP","FPN","FPR","FSU","LAR","LU","MPA","PA","PBP","PFP","PL","PPA","PST","RF","RG","RGF","RO","RR","SCA","SCB","SCC","SFA","SPP","STR","SW","TE","TP","TS","TSU","UL" }; }
    static StructureItem mFieldF8053 = null;
    static StructureItem getFieldF8053() { initCodeListF8053(); if (mFieldF8053 == null) initFieldF8053(); return mFieldF8053; }
    static void initFieldF8053 ()  { mFieldF8053 = new DataElement ("F8053",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8053  ))  ); }

    static StructureItem mFieldF8066 = null;
    static StructureItem getFieldF8066() {  if (mFieldF8066 == null) initFieldF8066(); return mFieldF8066; }
    static void initFieldF8066 ()  { mFieldF8066 = new DataElement ("F8066",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF8067 = null;
    static StructureItem getFieldF8067() {  if (mFieldF8067 == null) initFieldF8067(); return mFieldF8067; }
    static void initFieldF8067 ()  { mFieldF8067 = new DataElement ("F8067",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static String[] mCodeListF8077 = null;
    static void initCodeListF8077 () { mCodeListF8077 =
            new String[] { "1","2" }; }
    static StructureItem mFieldF8077 = null;
    static StructureItem getFieldF8077() { initCodeListF8077(); if (mFieldF8077 == null) initFieldF8077(); return mFieldF8077; }
    static void initFieldF8077 ()  { mFieldF8077 = new DataElement ("F8077",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8077  ))  ); }

    static String[] mCodeListF8101 = null;
    static void initCodeListF8101 () { mCodeListF8101 =
            new String[] { "BS","SB","SC","SD","SF","SS","ZZZ" }; }
    static StructureItem mFieldF8101 = null;
    static StructureItem getFieldF8101() { initCodeListF8101(); if (mFieldF8101 == null) initFieldF8101(); return mFieldF8101; }
    static void initFieldF8101 ()  { mFieldF8101 = new DataElement ("F8101",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8101  ))  ); }

    static StructureItem mFieldF8154 = null;
    static StructureItem getFieldF8154() {  if (mFieldF8154 == null) initFieldF8154(); return mFieldF8154; }
    static void initFieldF8154 ()  { mFieldF8154 = new DataElement ("F8154",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF8155 = null;
    static void initCodeListF8155 () { mCodeListF8155 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42" }; }
    static StructureItem mFieldF8155 = null;
    static StructureItem getFieldF8155() { initCodeListF8155(); if (mFieldF8155 == null) initFieldF8155(); return mFieldF8155; }
    static void initFieldF8155 ()  { mFieldF8155 = new DataElement ("F8155",
            new  DataTypeValidatorString(0, 10,  new DataValueCodeListValidator(true, mCodeListF8155  ))  ); }

    static String[] mCodeListF8169 = null;
    static void initCodeListF8169 () { mCodeListF8169 =
            new String[] { "1","2","3","4","5","6","7","8" }; }
    static StructureItem mFieldF8169 = null;
    static StructureItem getFieldF8169() { initCodeListF8169(); if (mFieldF8169 == null) initFieldF8169(); return mFieldF8169; }
    static void initFieldF8169 ()  { mFieldF8169 = new DataElement ("F8169",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8169  ))  ); }

    static StructureItem mFieldF8178 = null;
    static StructureItem getFieldF8178() {  if (mFieldF8178 == null) initFieldF8178(); return mFieldF8178; }
    static void initFieldF8178 ()  { mFieldF8178 = new DataElement ("F8178",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF8179 = null;
    static void initCodeListF8179 () { mCodeListF8179 =
            new String[] { "1","2","3","4","5","6","7","9","11","12","13","21","22","23","24","25","31","32","33","35","36","37","38" }; }
    static StructureItem mFieldF8179 = null;
    static StructureItem getFieldF8179() { initCodeListF8179(); if (mFieldF8179 == null) initFieldF8179(); return mFieldF8179; }
    static void initFieldF8179 ()  { mFieldF8179 = new DataElement ("F8179",
            new  DataTypeValidatorString(0, 8,  new DataValueCodeListValidator(true, mCodeListF8179  ))  ); }

    static StructureItem mFieldF8212 = null;
    static StructureItem getFieldF8212() {  if (mFieldF8212 == null) initFieldF8212(); return mFieldF8212; }
    static void initFieldF8212 ()  { mFieldF8212 = new DataElement ("F8212",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF8213 = null;
    static StructureItem getFieldF8213() {  if (mFieldF8213 == null) initFieldF8213(); return mFieldF8213; }
    static void initFieldF8213 ()  { mFieldF8213 = new DataElement ("F8213",
            new  DataTypeValidatorString(0, 9,  null  )  ); }

    static String[] mCodeListF8249 = null;
    static void initCodeListF8249 () { mCodeListF8249 =
            new String[] { "1","2","3","4","5","6" }; }
    static StructureItem mFieldF8249 = null;
    static StructureItem getFieldF8249() { initCodeListF8249(); if (mFieldF8249 == null) initFieldF8249(); return mFieldF8249; }
    static void initFieldF8249 ()  { mFieldF8249 = new DataElement ("F8249",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8249  ))  ); }

    static StructureItem mFieldF8260 = null;
    static StructureItem getFieldF8260() {  if (mFieldF8260 == null) initFieldF8260(); return mFieldF8260; }
    static void initFieldF8260 ()  { mFieldF8260 = new DataElement ("F8260",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF8275 = null;
    static void initCodeListF8275 () { mCodeListF8275 =
            new String[] { "1","2","3","4","5","6","7","8" }; }
    static StructureItem mFieldF8275 = null;
    static StructureItem getFieldF8275() { initCodeListF8275(); if (mFieldF8275 == null) initFieldF8275(); return mFieldF8275; }
    static void initFieldF8275 ()  { mFieldF8275 = new DataElement ("F8275",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8275  ))  ); }

    static String[] mCodeListF8281 = null;
    static void initCodeListF8281 () { mCodeListF8281 =
            new String[] { "1","2" }; }
    static StructureItem mFieldF8281 = null;
    static StructureItem getFieldF8281() { initCodeListF8281(); if (mFieldF8281 == null) initFieldF8281(); return mFieldF8281; }
    static void initFieldF8281 ()  { mFieldF8281 = new DataElement ("F8281",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8281  ))  ); }

    static String[] mCodeListF8393 = null;
    static void initCodeListF8393 () { mCodeListF8393 =
            new String[] { "1","2","3","4","5","6","7","8","9","10" }; }
    static StructureItem mFieldF8393 = null;
    static StructureItem getFieldF8393() { initCodeListF8393(); if (mFieldF8393 == null) initFieldF8393(); return mFieldF8393; }
    static void initFieldF8393 ()  { mFieldF8393 = new DataElement ("F8393",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8393  ))  ); }

    static String[] mCodeListF8395 = null;
    static void initCodeListF8395 () { mCodeListF8395 =
            new String[] { "1","2","3","ZZZ" }; }
    static StructureItem mFieldF8395 = null;
    static StructureItem getFieldF8395() { initCodeListF8395(); if (mFieldF8395 == null) initFieldF8395(); return mFieldF8395; }
    static void initFieldF8395 ()  { mFieldF8395 = new DataElement ("F8395",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8395  ))  ); }

    static StructureItem mFieldF8453 = null;
    static StructureItem getFieldF8453() {  if (mFieldF8453 == null) initFieldF8453(); return mFieldF8453; }
    static void initFieldF8453 ()  { mFieldF8453 = new DataElement ("F8453",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static String[] mCodeListF8457 = null;
    static void initCodeListF8457 () { mCodeListF8457 =
            new String[] { "A","B","C","D","E","F","G","H","I","J","K","L","M","N","P","R","T","U","V","W","X","Y","ZZZ" }; }
    static StructureItem mFieldF8457 = null;
    static StructureItem getFieldF8457() { initCodeListF8457(); if (mFieldF8457 == null) initFieldF8457(); return mFieldF8457; }
    static void initFieldF8457 ()  { mFieldF8457 = new DataElement ("F8457",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8457  ))  ); }

    static String[] mCodeListF8459 = null;
    static void initCodeListF8459 () { mCodeListF8459 =
            new String[] { "A","B","S","X","ZZZ" }; }
    static StructureItem mFieldF8459 = null;
    static StructureItem getFieldF8459() { initCodeListF8459(); if (mFieldF8459 == null) initFieldF8459(); return mFieldF8459; }
    static void initFieldF8459 ()  { mFieldF8459 = new DataElement ("F8459",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8459  ))  ); }

    static String[] mCodeListF9213 = null;
    static void initCodeListF9213 () { mCodeListF9213 =
            new String[] { "1","2","3","8","9" }; }
    static StructureItem mFieldF9213 = null;
    static StructureItem getFieldF9213() { initCodeListF9213(); if (mFieldF9213 == null) initFieldF9213(); return mFieldF9213; }
    static void initFieldF9213 ()  { mFieldF9213 = new DataElement ("F9213",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF9213  ))  ); }

    static StructureItem mFieldC002 = null;
    static StructureItem getFieldC002() {  if (mFieldC002 == null) initFieldC002(); return mFieldC002; }
    static void initFieldC002 ()
    {
        mFieldC002 = new Composite ("C002",
                new Particle[]{
                        new Particle("F1001", getFieldF1001(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F1000", getFieldF1000(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC040 = null;
    static StructureItem getFieldC040() {  if (mFieldC040 == null) initFieldC040(); return mFieldC040; }
    static void initFieldC040 ()
    {
        mFieldC040 = new Composite ("C040",
                new Particle[]{
                        new Particle("F3127", getFieldF3127(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3128", getFieldF3128(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC056 = null;
    static StructureItem getFieldC056() {  if (mFieldC056 == null) initFieldC056(); return mFieldC056; }
    static void initFieldC056 ()
    {
        mFieldC056 = new Composite ("C056",
                new Particle[]{
                        new Particle("F3413", getFieldF3413(), 0, 1, 1, false, new String[]{}),				new Particle("F3412", getFieldF3412(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC058 = null;
    static StructureItem getFieldC058() {  if (mFieldC058 == null) initFieldC058(); return mFieldC058; }
    static void initFieldC058 ()
    {
        mFieldC058 = new Composite ("C058",
                new Particle[]{
                        new Particle("F3124", getFieldF3124(), 1, 1, 5, false, new String[]{}),			});
    }

    static StructureItem mFieldC059 = null;
    static StructureItem getFieldC059() {  if (mFieldC059 == null) initFieldC059(); return mFieldC059; }
    static void initFieldC059 ()
    {
        mFieldC059 = new Composite ("C059",
                new Particle[]{
                        new Particle("F3042", getFieldF3042(), 1, 1, 4, false, new String[]{}),			});
    }

    static StructureItem mFieldC076 = null;
    static StructureItem getFieldC076() {  if (mFieldC076 == null) initFieldC076(); return mFieldC076; }
    static void initFieldC076 ()
    {
        mFieldC076 = new Composite ("C076",
                new Particle[]{
                        new Particle("F3148", getFieldF3148(), 1, 1, 1, false, new String[]{}),				new Particle("F3155", getFieldF3155(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC078 = null;
    static StructureItem getFieldC078() {  if (mFieldC078 == null) initFieldC078(); return mFieldC078; }
    static void initFieldC078 ()
    {
        mFieldC078 = new Composite ("C078",
                new Particle[]{
                        new Particle("F3194", getFieldF3194(), 0, 1, 1, false, new String[]{}),				new Particle("F3192", getFieldF3192(), 0, 1, 2, false, new String[]{}),				new Particle("F6345", getFieldF6345(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC080 = null;
    static StructureItem getFieldC080() {  if (mFieldC080 == null) initFieldC080(); return mFieldC080; }
    static void initFieldC080 ()
    {
        mFieldC080 = new Composite ("C080",
                new Particle[]{
                        new Particle("F3036", getFieldF3036(), 1, 1, 5, false, new String[]{}),				new Particle("F3045", getFieldF3045(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC082 = null;
    static StructureItem getFieldC082() {  if (mFieldC082 == null) initFieldC082(); return mFieldC082; }
    static void initFieldC082 ()
    {
        mFieldC082 = new Composite ("C082",
                new Particle[]{
                        new Particle("F3039", getFieldF3039(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC088 = null;
    static StructureItem getFieldC088() {  if (mFieldC088 == null) initFieldC088(); return mFieldC088; }
    static void initFieldC088 ()
    {
        mFieldC088 = new Composite ("C088",
                new Particle[]{
                        new Particle("F3433", getFieldF3433(), 0, 1, 1, false, new String[]{}),				new Particle("F1131_1", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_1", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3434", getFieldF3434(), 0, 1, 1, false, new String[]{}),				new Particle("F1131_2", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_2", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3432", getFieldF3432(), 0, 1, 1, false, new String[]{}),				new Particle("F3436", getFieldF3436(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC100 = null;
    static StructureItem getFieldC100() {  if (mFieldC100 == null) initFieldC100(); return mFieldC100; }
    static void initFieldC100 ()
    {
        mFieldC100 = new Composite ("C100",
                new Particle[]{
                        new Particle("F4053", getFieldF4053(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F4052", getFieldF4052(), 0, 1, 2, false, new String[]{}),			});
    }

    static StructureItem mFieldC107 = null;
    static StructureItem getFieldC107() {  if (mFieldC107 == null) initFieldC107(); return mFieldC107; }
    static void initFieldC107 ()
    {
        mFieldC107 = new Composite ("C107",
                new Particle[]{
                        new Particle("F4441", getFieldF4441(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC108 = null;
    static StructureItem getFieldC108() {  if (mFieldC108 == null) initFieldC108(); return mFieldC108; }
    static void initFieldC108 ()
    {
        mFieldC108 = new Composite ("C108",
                new Particle[]{
                        new Particle("F4440", getFieldF4440(), 1, 1, 5, false, new String[]{}),			});
    }

    static StructureItem mFieldC110 = null;
    static StructureItem getFieldC110() {  if (mFieldC110 == null) initFieldC110(); return mFieldC110; }
    static void initFieldC110 ()
    {
        mFieldC110 = new Composite ("C110",
                new Particle[]{
                        new Particle("F4277", getFieldF4277(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F4276", getFieldF4276(), 0, 1, 2, false, new String[]{}),			});
    }

    static StructureItem mFieldC112 = null;
    static StructureItem getFieldC112() {  if (mFieldC112 == null) initFieldC112(); return mFieldC112; }
    static void initFieldC112 ()
    {
        mFieldC112 = new Composite ("C112",
                new Particle[]{
                        new Particle("F2475", getFieldF2475(), 1, 1, 1, false, new String[]{}),				new Particle("F2009", getFieldF2009(), 0, 1, 1, false, new String[]{}),				new Particle("F2151", getFieldF2151(), 0, 1, 1, false, new String[]{}),				new Particle("F2152", getFieldF2152(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC128 = null;
    static StructureItem getFieldC128() {  if (mFieldC128 == null) initFieldC128(); return mFieldC128; }
    static void initFieldC128 ()
    {
        mFieldC128 = new Composite ("C128",
                new Particle[]{
                        new Particle("F5419", getFieldF5419(), 1, 1, 1, false, new String[]{}),				new Particle("F5420", getFieldF5420(), 1, 1, 1, false, new String[]{}),				new Particle("F5284", getFieldF5284(), 0, 1, 1, false, new String[]{}),				new Particle("F6411", getFieldF6411(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC138 = null;
    static StructureItem getFieldC138() {  if (mFieldC138 == null) initFieldC138(); return mFieldC138; }
    static void initFieldC138 ()
    {
        mFieldC138 = new Composite ("C138",
                new Particle[]{
                        new Particle("F5394", getFieldF5394(), 1, 1, 1, false, new String[]{}),				new Particle("F5393", getFieldF5393(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC174 = null;
    static StructureItem getFieldC174() {  if (mFieldC174 == null) initFieldC174(); return mFieldC174; }
    static void initFieldC174 ()
    {
        mFieldC174 = new Composite ("C174",
                new Particle[]{
                        new Particle("F6411", getFieldF6411(), 1, 1, 1, false, new String[]{}),				new Particle("F6314", getFieldF6314(), 0, 1, 1, false, new String[]{}),				new Particle("F6162", getFieldF6162(), 0, 1, 1, false, new String[]{}),				new Particle("F6152", getFieldF6152(), 0, 1, 1, false, new String[]{}),				new Particle("F6432", getFieldF6432(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC186 = null;
    static StructureItem getFieldC186() {  if (mFieldC186 == null) initFieldC186(); return mFieldC186; }
    static void initFieldC186 ()
    {
        mFieldC186 = new Composite ("C186",
                new Particle[]{
                        new Particle("F6063", getFieldF6063(), 1, 1, 1, false, new String[]{}),				new Particle("F6060", getFieldF6060(), 1, 1, 1, false, new String[]{}),				new Particle("F6411", getFieldF6411(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC202 = null;
    static StructureItem getFieldC202() {  if (mFieldC202 == null) initFieldC202(); return mFieldC202; }
    static void initFieldC202 ()
    {
        mFieldC202 = new Composite ("C202",
                new Particle[]{
                        new Particle("F7065", getFieldF7065(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F7064", getFieldF7064(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC206 = null;
    static StructureItem getFieldC206() {  if (mFieldC206 == null) initFieldC206(); return mFieldC206; }
    static void initFieldC206 ()
    {
        mFieldC206 = new Composite ("C206",
                new Particle[]{
                        new Particle("F7402", getFieldF7402(), 1, 1, 1, false, new String[]{}),				new Particle("F7405", getFieldF7405(), 0, 1, 1, false, new String[]{}),				new Particle("F4405", getFieldF4405(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC208 = null;
    static StructureItem getFieldC208() {  if (mFieldC208 == null) initFieldC208(); return mFieldC208; }
    static void initFieldC208 ()
    {
        mFieldC208 = new Composite ("C208",
                new Particle[]{
                        new Particle("F7402", getFieldF7402(), 1, 1, 2, false, new String[]{}),			});
    }

    static StructureItem mFieldC210 = null;
    static StructureItem getFieldC210() {  if (mFieldC210 == null) initFieldC210(); return mFieldC210; }
    static void initFieldC210 ()
    {
        mFieldC210 = new Composite ("C210",
                new Particle[]{
                        new Particle("F7102", getFieldF7102(), 1, 1, 10, false, new String[]{}),			});
    }

    static StructureItem mFieldC212 = null;
    static StructureItem getFieldC212() {  if (mFieldC212 == null) initFieldC212(); return mFieldC212; }
    static void initFieldC212 ()
    {
        mFieldC212 = new Composite ("C212",
                new Particle[]{
                        new Particle("F7140", getFieldF7140(), 0, 1, 1, false, new String[]{}),				new Particle("F7143", getFieldF7143(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC214 = null;
    static StructureItem getFieldC214() {  if (mFieldC214 == null) initFieldC214(); return mFieldC214; }
    static void initFieldC214 ()
    {
        mFieldC214 = new Composite ("C214",
                new Particle[]{
                        new Particle("F7161", getFieldF7161(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F7160", getFieldF7160(), 0, 1, 2, false, new String[]{}),			});
    }

    static StructureItem mFieldC220 = null;
    static StructureItem getFieldC220() {  if (mFieldC220 == null) initFieldC220(); return mFieldC220; }
    static void initFieldC220 ()
    {
        mFieldC220 = new Composite ("C220",
                new Particle[]{
                        new Particle("F8067", getFieldF8067(), 0, 1, 1, false, new String[]{}),				new Particle("F8066", getFieldF8066(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC222 = null;
    static StructureItem getFieldC222() {  if (mFieldC222 == null) initFieldC222(); return mFieldC222; }
    static void initFieldC222 ()
    {
        mFieldC222 = new Composite ("C222",
                new Particle[]{
                        new Particle("F8213", getFieldF8213(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F8212", getFieldF8212(), 0, 1, 1, false, new String[]{}),				new Particle("F8453", getFieldF8453(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC224 = null;
    static StructureItem getFieldC224() {  if (mFieldC224 == null) initFieldC224(); return mFieldC224; }
    static void initFieldC224 ()
    {
        mFieldC224 = new Composite ("C224",
                new Particle[]{
                        new Particle("F8155", getFieldF8155(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F8154", getFieldF8154(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC228 = null;
    static StructureItem getFieldC228() {  if (mFieldC228 == null) initFieldC228(); return mFieldC228; }
    static void initFieldC228 ()
    {
        mFieldC228 = new Composite ("C228",
                new Particle[]{
                        new Particle("F8179", getFieldF8179(), 0, 1, 1, false, new String[]{}),				new Particle("F8178", getFieldF8178(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC237 = null;
    static StructureItem getFieldC237() {  if (mFieldC237 == null) initFieldC237(); return mFieldC237; }
    static void initFieldC237 ()
    {
        mFieldC237 = new Composite ("C237",
                new Particle[]{
                        new Particle("F8260", getFieldF8260(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3207", getFieldF3207(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC241 = null;
    static StructureItem getFieldC241() {  if (mFieldC241 == null) initFieldC241(); return mFieldC241; }
    static void initFieldC241 ()
    {
        mFieldC241 = new Composite ("C241",
                new Particle[]{
                        new Particle("F5153", getFieldF5153(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F5152", getFieldF5152(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC243 = null;
    static StructureItem getFieldC243() {  if (mFieldC243 == null) initFieldC243(); return mFieldC243; }
    static void initFieldC243 ()
    {
        mFieldC243 = new Composite ("C243",
                new Particle[]{
                        new Particle("F5279", getFieldF5279(), 0, 1, 1, false, new String[]{}),				new Particle("F1131_1", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_1", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F5278", getFieldF5278(), 0, 1, 1, false, new String[]{}),				new Particle("F5273", getFieldF5273(), 0, 1, 1, false, new String[]{}),				new Particle("F1131_2", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_2", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC270 = null;
    static StructureItem getFieldC270() {  if (mFieldC270 == null) initFieldC270(); return mFieldC270; }
    static void initFieldC270 ()
    {
        mFieldC270 = new Composite ("C270",
                new Particle[]{
                        new Particle("F6069", getFieldF6069(), 1, 1, 1, false, new String[]{}),				new Particle("F6066", getFieldF6066(), 1, 1, 1, false, new String[]{}),				new Particle("F6411", getFieldF6411(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC273 = null;
    static StructureItem getFieldC273() {  if (mFieldC273 == null) initFieldC273(); return mFieldC273; }
    static void initFieldC273 ()
    {
        mFieldC273 = new Composite ("C273",
                new Particle[]{
                        new Particle("F7009", getFieldF7009(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F7008", getFieldF7008(), 0, 1, 2, false, new String[]{}),				new Particle("F3453", getFieldF3453(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC279 = null;
    static StructureItem getFieldC279() {  if (mFieldC279 == null) initFieldC279(); return mFieldC279; }
    static void initFieldC279 ()
    {
        mFieldC279 = new Composite ("C279",
                new Particle[]{
                        new Particle("F6064", getFieldF6064(), 1, 1, 1, false, new String[]{}),				new Particle("F6063", getFieldF6063(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC280 = null;
    static StructureItem getFieldC280() {  if (mFieldC280 == null) initFieldC280(); return mFieldC280; }
    static void initFieldC280 ()
    {
        mFieldC280 = new Composite ("C280",
                new Particle[]{
                        new Particle("F6411", getFieldF6411(), 1, 1, 1, false, new String[]{}),				new Particle("F6162", getFieldF6162(), 0, 1, 1, false, new String[]{}),				new Particle("F6152", getFieldF6152(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC401 = null;
    static StructureItem getFieldC401() {  if (mFieldC401 == null) initFieldC401(); return mFieldC401; }
    static void initFieldC401 ()
    {
        mFieldC401 = new Composite ("C401",
                new Particle[]{
                        new Particle("F8457", getFieldF8457(), 1, 1, 1, false, new String[]{}),				new Particle("F8459", getFieldF8459(), 1, 1, 1, false, new String[]{}),				new Particle("F7130", getFieldF7130(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC402 = null;
    static StructureItem getFieldC402() {  if (mFieldC402 == null) initFieldC402(); return mFieldC402; }
    static void initFieldC402 ()
    {
        mFieldC402 = new Composite ("C402",
                new Particle[]{
                        new Particle("F7077", getFieldF7077(), 1, 1, 1, false, new String[]{}),				new Particle("F7064_1", getFieldF7064(), 1, 1, 1, false, new String[]{}),				new Particle("F7143_1", getFieldF7143(), 0, 1, 1, false, new String[]{}),				new Particle("F7064_2", getFieldF7064(), 0, 1, 1, false, new String[]{}),				new Particle("F7143_2", getFieldF7143(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC501 = null;
    static StructureItem getFieldC501() {  if (mFieldC501 == null) initFieldC501(); return mFieldC501; }
    static void initFieldC501 ()
    {
        mFieldC501 = new Composite ("C501",
                new Particle[]{
                        new Particle("F5245", getFieldF5245(), 1, 1, 1, false, new String[]{}),				new Particle("F5482", getFieldF5482(), 0, 1, 1, false, new String[]{}),				new Particle("F5249", getFieldF5249(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC502 = null;
    static StructureItem getFieldC502() {  if (mFieldC502 == null) initFieldC502(); return mFieldC502; }
    static void initFieldC502 ()
    {
        mFieldC502 = new Composite ("C502",
                new Particle[]{
                        new Particle("F6313", getFieldF6313(), 0, 1, 1, false, new String[]{}),				new Particle("F6321", getFieldF6321(), 0, 1, 1, false, new String[]{}),				new Particle("F6155", getFieldF6155(), 0, 1, 1, false, new String[]{}),				new Particle("F6154", getFieldF6154(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC503 = null;
    static StructureItem getFieldC503() {  if (mFieldC503 == null) initFieldC503(); return mFieldC503; }
    static void initFieldC503 ()
    {
        mFieldC503 = new Composite ("C503",
                new Particle[]{
                        new Particle("F1004", getFieldF1004(), 0, 1, 1, false, new String[]{}),				new Particle("F1373", getFieldF1373(), 0, 1, 1, false, new String[]{}),				new Particle("F1366", getFieldF1366(), 0, 1, 1, false, new String[]{}),				new Particle("F3453", getFieldF3453(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC504 = null;
    static StructureItem getFieldC504() {  if (mFieldC504 == null) initFieldC504(); return mFieldC504; }
    static void initFieldC504 ()
    {
        mFieldC504 = new Composite ("C504",
                new Particle[]{
                        new Particle("F6347", getFieldF6347(), 1, 1, 1, false, new String[]{}),				new Particle("F6345", getFieldF6345(), 0, 1, 1, false, new String[]{}),				new Particle("F6343", getFieldF6343(), 0, 1, 1, false, new String[]{}),				new Particle("F6348", getFieldF6348(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC506 = null;
    static StructureItem getFieldC506() {  if (mFieldC506 == null) initFieldC506(); return mFieldC506; }
    static void initFieldC506 ()
    {
        mFieldC506 = new Composite ("C506",
                new Particle[]{
                        new Particle("F1153", getFieldF1153(), 1, 1, 1, false, new String[]{}),				new Particle("F1154", getFieldF1154(), 0, 1, 1, false, new String[]{}),				new Particle("F1156", getFieldF1156(), 0, 1, 1, false, new String[]{}),				new Particle("F4000", getFieldF4000(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC507 = null;
    static StructureItem getFieldC507() {  if (mFieldC507 == null) initFieldC507(); return mFieldC507; }
    static void initFieldC507 ()
    {
        mFieldC507 = new Composite ("C507",
                new Particle[]{
                        new Particle("F2005", getFieldF2005(), 1, 1, 1, false, new String[]{}),				new Particle("F2380", getFieldF2380(), 0, 1, 1, false, new String[]{}),				new Particle("F2379", getFieldF2379(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC509 = null;
    static StructureItem getFieldC509() {  if (mFieldC509 == null) initFieldC509(); return mFieldC509; }
    static void initFieldC509 ()
    {
        mFieldC509 = new Composite ("C509",
                new Particle[]{
                        new Particle("F5125", getFieldF5125(), 1, 1, 1, false, new String[]{}),				new Particle("F5118", getFieldF5118(), 0, 1, 1, false, new String[]{}),				new Particle("F5375", getFieldF5375(), 0, 1, 1, false, new String[]{}),				new Particle("F5387", getFieldF5387(), 0, 1, 1, false, new String[]{}),				new Particle("F5284", getFieldF5284(), 0, 1, 1, false, new String[]{}),				new Particle("F6411", getFieldF6411(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC516 = null;
    static StructureItem getFieldC516() {  if (mFieldC516 == null) initFieldC516(); return mFieldC516; }
    static void initFieldC516 ()
    {
        mFieldC516 = new Composite ("C516",
                new Particle[]{
                        new Particle("F5025", getFieldF5025(), 1, 1, 1, false, new String[]{}),				new Particle("F5004", getFieldF5004(), 0, 1, 1, false, new String[]{}),				new Particle("F6345", getFieldF6345(), 0, 1, 1, false, new String[]{}),				new Particle("F6343", getFieldF6343(), 0, 1, 1, false, new String[]{}),				new Particle("F4405", getFieldF4405(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC517 = null;
    static StructureItem getFieldC517() {  if (mFieldC517 == null) initFieldC517(); return mFieldC517; }
    static void initFieldC517 ()
    {
        mFieldC517 = new Composite ("C517",
                new Particle[]{
                        new Particle("F3225", getFieldF3225(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3224", getFieldF3224(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC519 = null;
    static StructureItem getFieldC519() {  if (mFieldC519 == null) initFieldC519(); return mFieldC519; }
    static void initFieldC519 ()
    {
        mFieldC519 = new Composite ("C519",
                new Particle[]{
                        new Particle("F3223", getFieldF3223(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3222", getFieldF3222(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC522 = null;
    static StructureItem getFieldC522() {  if (mFieldC522 == null) initFieldC522(); return mFieldC522; }
    static void initFieldC522 ()
    {
        mFieldC522 = new Composite ("C522",
                new Particle[]{
                        new Particle("F4403", getFieldF4403(), 1, 1, 1, false, new String[]{}),				new Particle("F4401", getFieldF4401(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F4400", getFieldF4400(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC531 = null;
    static StructureItem getFieldC531() {  if (mFieldC531 == null) initFieldC531(); return mFieldC531; }
    static void initFieldC531 ()
    {
        mFieldC531 = new Composite ("C531",
                new Particle[]{
                        new Particle("F7075", getFieldF7075(), 0, 1, 1, false, new String[]{}),				new Particle("F7233", getFieldF7233(), 0, 1, 1, false, new String[]{}),				new Particle("F7073", getFieldF7073(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC532 = null;
    static StructureItem getFieldC532() {  if (mFieldC532 == null) initFieldC532(); return mFieldC532; }
    static void initFieldC532 ()
    {
        mFieldC532 = new Composite ("C532",
                new Particle[]{
                        new Particle("F8395", getFieldF8395(), 0, 1, 1, false, new String[]{}),				new Particle("F8393", getFieldF8393(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC533 = null;
    static StructureItem getFieldC533() {  if (mFieldC533 == null) initFieldC533(); return mFieldC533; }
    static void initFieldC533 ()
    {
        mFieldC533 = new Composite ("C533",
                new Particle[]{
                        new Particle("F5289", getFieldF5289(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC534 = null;
    static StructureItem getFieldC534() {  if (mFieldC534 == null) initFieldC534(); return mFieldC534; }
    static void initFieldC534 ()
    {
        mFieldC534 = new Composite ("C534",
                new Particle[]{
                        new Particle("F4439", getFieldF4439(), 0, 1, 1, false, new String[]{}),				new Particle("F4431", getFieldF4431(), 0, 1, 1, false, new String[]{}),				new Particle("F4461", getFieldF4461(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F4435", getFieldF4435(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC550 = null;
    static StructureItem getFieldC550() {  if (mFieldC550 == null) initFieldC550(); return mFieldC550; }
    static void initFieldC550 ()
    {
        mFieldC550 = new Composite ("C550",
                new Particle[]{
                        new Particle("F7295", getFieldF7295(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F7294", getFieldF7294(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC552 = null;
    static StructureItem getFieldC552() {  if (mFieldC552 == null) initFieldC552(); return mFieldC552; }
    static void initFieldC552 ()
    {
        mFieldC552 = new Composite ("C552",
                new Particle[]{
                        new Particle("F1230", getFieldF1230(), 0, 1, 1, false, new String[]{}),				new Particle("F5189", getFieldF5189(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC553 = null;
    static StructureItem getFieldC553() {  if (mFieldC553 == null) initFieldC553(); return mFieldC553; }
    static void initFieldC553 ()
    {
        mFieldC553 = new Composite ("C553",
                new Particle[]{
                        new Particle("F3233", getFieldF3233(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3232", getFieldF3232(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC827 = null;
    static StructureItem getFieldC827() {  if (mFieldC827 == null) initFieldC827(); return mFieldC827; }
    static void initFieldC827 ()
    {
        mFieldC827 = new Composite ("C827",
                new Particle[]{
                        new Particle("F7511", getFieldF7511(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC829 = null;
    static StructureItem getFieldC829() {  if (mFieldC829 == null) initFieldC829(); return mFieldC829; }
    static void initFieldC829 ()
    {
        mFieldC829 = new Composite ("C829",
                new Particle[]{
                        new Particle("F5495", getFieldF5495(), 0, 1, 1, false, new String[]{}),				new Particle("F1082", getFieldF1082(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC849 = null;
    static StructureItem getFieldC849() {  if (mFieldC849 == null) initFieldC849(); return mFieldC849; }
    static void initFieldC849 ()
    {
        mFieldC849 = new Composite ("C849",
                new Particle[]{
                        new Particle("F3301", getFieldF3301(), 1, 1, 1, false, new String[]{}),				new Particle("F3285", getFieldF3285(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC850 = null;
    static StructureItem getFieldC850() {  if (mFieldC850 == null) initFieldC850(); return mFieldC850; }
    static void initFieldC850 ()
    {
        mFieldC850 = new Composite ("C850",
                new Particle[]{
                        new Particle("F4405", getFieldF4405(), 1, 1, 1, false, new String[]{}),				new Particle("F3036", getFieldF3036(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC960 = null;
    static StructureItem getFieldC960() {  if (mFieldC960 == null) initFieldC960(); return mFieldC960; }
    static void initFieldC960 ()
    {
        mFieldC960 = new Composite ("C960",
                new Particle[]{
                        new Particle("F4295", getFieldF4295(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F4294", getFieldF4294(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS001 = null;
    static StructureItem getFieldS001() {  if (mFieldS001 == null) initFieldS001(); return mFieldS001; }
    static void initFieldS001 ()
    {
        mFieldS001 = new Composite ("S001",
                new Particle[]{
                        new Particle("F0001", getFieldF0001(), 1, 1, 1, false, new String[]{}),				new Particle("F0002", getFieldF0002(), 1, 1, 1, false, new String[]{}),				new Particle("F0080", getFieldF0080(), 0, 1, 1, false, new String[]{}),				new Particle("F0133", getFieldF0133(), 0, 1, 1, false, new String[]{}),				new Particle("F0076", getFieldF0076(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS002 = null;
    static StructureItem getFieldS002() {  if (mFieldS002 == null) initFieldS002(); return mFieldS002; }
    static void initFieldS002 ()
    {
        mFieldS002 = new Composite ("S002",
                new Particle[]{
                        new Particle("F0004", getFieldF0004(), 1, 1, 1, false, new String[]{}),				new Particle("F0007", getFieldF0007(), 0, 1, 1, false, new String[]{}),				new Particle("F0008", getFieldF0008(), 0, 1, 1, false, new String[]{}),				new Particle("F0042", getFieldF0042(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS003 = null;
    static StructureItem getFieldS003() {  if (mFieldS003 == null) initFieldS003(); return mFieldS003; }
    static void initFieldS003 ()
    {
        mFieldS003 = new Composite ("S003",
                new Particle[]{
                        new Particle("F0010", getFieldF0010(), 1, 1, 1, false, new String[]{}),				new Particle("F0007", getFieldF0007(), 0, 1, 1, false, new String[]{}),				new Particle("F0014", getFieldF0014(), 0, 1, 1, false, new String[]{}),				new Particle("F0046", getFieldF0046(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS004 = null;
    static StructureItem getFieldS004() {  if (mFieldS004 == null) initFieldS004(); return mFieldS004; }
    static void initFieldS004 ()
    {
        mFieldS004 = new Composite ("S004",
                new Particle[]{
                        new Particle("F0017", getFieldF0017(), 1, 1, 1, false, new String[]{}),				new Particle("F0019", getFieldF0019(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS005 = null;
    static StructureItem getFieldS005() {  if (mFieldS005 == null) initFieldS005(); return mFieldS005; }
    static void initFieldS005 ()
    {
        mFieldS005 = new Composite ("S005",
                new Particle[]{
                        new Particle("F0022", getFieldF0022(), 1, 1, 1, false, new String[]{}),				new Particle("F0025", getFieldF0025(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS006 = null;
    static StructureItem getFieldS006() {  if (mFieldS006 == null) initFieldS006(); return mFieldS006; }
    static void initFieldS006 ()
    {
        mFieldS006 = new Composite ("S006",
                new Particle[]{
                        new Particle("F0040", getFieldF0040(), 1, 1, 1, false, new String[]{}),				new Particle("F0007", getFieldF0007(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS007 = null;
    static StructureItem getFieldS007() {  if (mFieldS007 == null) initFieldS007(); return mFieldS007; }
    static void initFieldS007 ()
    {
        mFieldS007 = new Composite ("S007",
                new Particle[]{
                        new Particle("F0044", getFieldF0044(), 1, 1, 1, false, new String[]{}),				new Particle("F0007", getFieldF0007(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS008 = null;
    static StructureItem getFieldS008() {  if (mFieldS008 == null) initFieldS008(); return mFieldS008; }
    static void initFieldS008 ()
    {
        mFieldS008 = new Composite ("S008",
                new Particle[]{
                        new Particle("F0052", getFieldF0052(), 1, 1, 1, false, new String[]{}),				new Particle("F0054", getFieldF0054(), 1, 1, 1, false, new String[]{}),				new Particle("F0057", getFieldF0057(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS009 = null;
    static StructureItem getFieldS009() {  if (mFieldS009 == null) initFieldS009(); return mFieldS009; }
    static void initFieldS009 ()
    {
        mFieldS009 = new Composite ("S009",
                new Particle[]{
                        new Particle("F0065", getFieldF0065(), 1, 1, 1, false, new String[]{}),				new Particle("F0052", getFieldF0052(), 1, 1, 1, false, new String[]{}),				new Particle("F0054", getFieldF0054(), 1, 1, 1, false, new String[]{}),				new Particle("F0051", getFieldF0051(), 1, 1, 1, false, new String[]{}),				new Particle("F0057", getFieldF0057(), 0, 1, 1, false, new String[]{}),				new Particle("F0110", getFieldF0110(), 0, 1, 1, false, new String[]{}),				new Particle("F0113", getFieldF0113(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS010 = null;
    static StructureItem getFieldS010() {  if (mFieldS010 == null) initFieldS010(); return mFieldS010; }
    static void initFieldS010 ()
    {
        mFieldS010 = new Composite ("S010",
                new Particle[]{
                        new Particle("F0070", getFieldF0070(), 1, 1, 1, false, new String[]{}),				new Particle("F0073", getFieldF0073(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS016 = null;
    static StructureItem getFieldS016() {  if (mFieldS016 == null) initFieldS016(); return mFieldS016; }
    static void initFieldS016 ()
    {
        mFieldS016 = new Composite ("S016",
                new Particle[]{
                        new Particle("F0115", getFieldF0115(), 1, 1, 1, false, new String[]{}),				new Particle("F0116", getFieldF0116(), 0, 1, 1, false, new String[]{}),				new Particle("F0118", getFieldF0118(), 0, 1, 1, false, new String[]{}),				new Particle("F0051", getFieldF0051(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS017 = null;
    static StructureItem getFieldS017() {  if (mFieldS017 == null) initFieldS017(); return mFieldS017; }
    static void initFieldS017 ()
    {
        mFieldS017 = new Composite ("S017",
                new Particle[]{
                        new Particle("F0121", getFieldF0121(), 1, 1, 1, false, new String[]{}),				new Particle("F0122", getFieldF0122(), 0, 1, 1, false, new String[]{}),				new Particle("F0124", getFieldF0124(), 0, 1, 1, false, new String[]{}),				new Particle("F0051", getFieldF0051(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldS018 = null;
    static StructureItem getFieldS018() {  if (mFieldS018 == null) initFieldS018(); return mFieldS018; }
    static void initFieldS018 ()
    {
        mFieldS018 = new Composite ("S018",
                new Particle[]{
                        new Particle("F0127", getFieldF0127(), 1, 1, 1, false, new String[]{}),				new Particle("F0128", getFieldF0128(), 0, 1, 1, false, new String[]{}),				new Particle("F0130", getFieldF0130(), 0, 1, 1, false, new String[]{}),				new Particle("F0051", getFieldF0051(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureAJT = null;
    static StructureItem getStructureAJT() {  if (mStructureAJT == null) initStructureAJT(); return mStructureAJT; }
    static void initStructureAJT ()
    {
        mStructureAJT = new Segment ("AJT","", "",
                new Particle[]{
                        new Particle("F4465", getFieldF4465(), 1, 1, 1, false, new String[]{}),				new Particle("F1082", getFieldF1082(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureALC = null;
    static StructureItem getStructureALC() {  if (mStructureALC == null) initStructureALC(); return mStructureALC; }
    static void initStructureALC ()
    {
        mStructureALC = new Segment ("ALC","", "",
                new Particle[]{
                        new Particle("F5463", getFieldF5463(), 1, 1, 1, false, new String[]{}),				new Particle("C552", getFieldC552(), 0, 1, 1, false, new String[]{}),				new Particle("F4471", getFieldF4471(), 0, 1, 1, false, new String[]{}),				new Particle("F1227", getFieldF1227(), 0, 1, 1, false, new String[]{}),				new Particle("C214", getFieldC214(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureALI = null;
    static StructureItem getStructureALI() {  if (mStructureALI == null) initStructureALI(); return mStructureALI; }
    static void initStructureALI ()
    {
        mStructureALI = new Segment ("ALI","", "",
                new Particle[]{
                        new Particle("F3239", getFieldF3239(), 0, 1, 1, false, new String[]{}),				new Particle("F9213", getFieldF9213(), 0, 1, 1, false, new String[]{}),				new Particle("F4183", getFieldF4183(), 0, 1, 5, false, new String[]{}),			});
    }

    static StructureItem mStructureAPR = null;
    static StructureItem getStructureAPR() {  if (mStructureAPR == null) initStructureAPR(); return mStructureAPR; }
    static void initStructureAPR ()
    {
        mStructureAPR = new Segment ("APR","", "",
                new Particle[]{
                        new Particle("F4043", getFieldF4043(), 0, 1, 1, false, new String[]{}),				new Particle("C138", getFieldC138(), 0, 1, 1, false, new String[]{}),				new Particle("C960", getFieldC960(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureBGM = null;
    static StructureItem getStructureBGM() {  if (mStructureBGM == null) initStructureBGM(); return mStructureBGM; }
    static void initStructureBGM ()
    {
        mStructureBGM = new Segment ("BGM","", "",
                new Particle[]{
                        new Particle("C002", getFieldC002(), 0, 1, 1, false, new String[]{}),				new Particle("F1004", getFieldF1004(), 0, 1, 1, false, new String[]{}),				new Particle("F1225", getFieldF1225(), 0, 1, 1, false, new String[]{}),				new Particle("F4343", getFieldF4343(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureCNT = null;
    static StructureItem getStructureCNT() {  if (mStructureCNT == null) initStructureCNT(); return mStructureCNT; }
    static void initStructureCNT ()
    {
        mStructureCNT = new Segment ("CNT","", "",
                new Particle[]{
                        new Particle("C270", getFieldC270(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureCOM = null;
    static StructureItem getStructureCOM() {  if (mStructureCOM == null) initStructureCOM(); return mStructureCOM; }
    static void initStructureCOM ()
    {
        mStructureCOM = new Segment ("COM","", "",
                new Particle[]{
                        new Particle("C076", getFieldC076(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureCTA = null;
    static StructureItem getStructureCTA() {  if (mStructureCTA == null) initStructureCTA(); return mStructureCTA; }
    static void initStructureCTA ()
    {
        mStructureCTA = new Segment ("CTA","", "",
                new Particle[]{
                        new Particle("F3139", getFieldF3139(), 0, 1, 1, false, new String[]{}),				new Particle("C056", getFieldC056(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureCUX = null;
    static StructureItem getStructureCUX() {  if (mStructureCUX == null) initStructureCUX(); return mStructureCUX; }
    static void initStructureCUX ()
    {
        mStructureCUX = new Segment ("CUX","", "",
                new Particle[]{
                        new Particle("C504", getFieldC504(), 0, 1, 2, false, new String[]{}),				new Particle("F5402", getFieldF5402(), 0, 1, 1, false, new String[]{}),				new Particle("F6341", getFieldF6341(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureDOC = null;
    static StructureItem getStructureDOC() {  if (mStructureDOC == null) initStructureDOC(); return mStructureDOC; }
    static void initStructureDOC ()
    {
        mStructureDOC = new Segment ("DOC","", "",
                new Particle[]{
                        new Particle("C002", getFieldC002(), 1, 1, 1, false, new String[]{}),				new Particle("C503", getFieldC503(), 0, 1, 1, false, new String[]{}),				new Particle("F3153", getFieldF3153(), 0, 1, 1, false, new String[]{}),				new Particle("F1220", getFieldF1220(), 0, 1, 1, false, new String[]{}),				new Particle("F1218", getFieldF1218(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureDTM = null;
    static StructureItem getStructureDTM() {  if (mStructureDTM == null) initStructureDTM(); return mStructureDTM; }
    static void initStructureDTM ()
    {
        mStructureDTM = new Segment ("DTM","", "",
                new Particle[]{
                        new Particle("C507", getFieldC507(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureEQD = null;
    static StructureItem getStructureEQD() {  if (mStructureEQD == null) initStructureEQD(); return mStructureEQD; }
    static void initStructureEQD ()
    {
        mStructureEQD = new Segment ("EQD","", "",
                new Particle[]{
                        new Particle("F8053", getFieldF8053(), 1, 1, 1, false, new String[]{}),				new Particle("C237", getFieldC237(), 0, 1, 1, false, new String[]{}),				new Particle("C224", getFieldC224(), 0, 1, 1, false, new String[]{}),				new Particle("F8077", getFieldF8077(), 0, 1, 1, false, new String[]{}),				new Particle("F8249", getFieldF8249(), 0, 1, 1, false, new String[]{}),				new Particle("F8169", getFieldF8169(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureFII = null;
    static StructureItem getStructureFII() {  if (mStructureFII == null) initStructureFII(); return mStructureFII; }
    static void initStructureFII ()
    {
        mStructureFII = new Segment ("FII","", "",
                new Particle[]{
                        new Particle("F3035", getFieldF3035(), 1, 1, 1, false, new String[]{}),				new Particle("C078", getFieldC078(), 0, 1, 1, false, new String[]{}),				new Particle("C088", getFieldC088(), 0, 1, 1, false, new String[]{}),				new Particle("F3207", getFieldF3207(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureFTX = null;
    static StructureItem getStructureFTX() {  if (mStructureFTX == null) initStructureFTX(); return mStructureFTX; }
    static void initStructureFTX ()
    {
        mStructureFTX = new Segment ("FTX","", "",
                new Particle[]{
                        new Particle("F4451", getFieldF4451(), 1, 1, 1, false, new String[]{}),				new Particle("F4453", getFieldF4453(), 0, 1, 1, false, new String[]{}),				new Particle("C107", getFieldC107(), 0, 1, 1, false, new String[]{}),				new Particle("C108", getFieldC108(), 0, 1, 1, false, new String[]{}),				new Particle("F3453", getFieldF3453(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureGIN = null;
    static StructureItem getStructureGIN() {  if (mStructureGIN == null) initStructureGIN(); return mStructureGIN; }
    static void initStructureGIN ()
    {
        mStructureGIN = new Segment ("GIN","", "",
                new Particle[]{
                        new Particle("F7405", getFieldF7405(), 1, 1, 1, false, new String[]{}),				new Particle("C208", getFieldC208(), 1, 1, 5, false, new String[]{}),			});
    }

    static StructureItem mStructureGIR = null;
    static StructureItem getStructureGIR() {  if (mStructureGIR == null) initStructureGIR(); return mStructureGIR; }
    static void initStructureGIR ()
    {
        mStructureGIR = new Segment ("GIR","", "",
                new Particle[]{
                        new Particle("F7297", getFieldF7297(), 1, 1, 1, false, new String[]{}),				new Particle("C206", getFieldC206(), 1, 1, 5, false, new String[]{}),			});
    }

    static StructureItem mStructureIMD = null;
    static StructureItem getStructureIMD() {  if (mStructureIMD == null) initStructureIMD(); return mStructureIMD; }
    static void initStructureIMD ()
    {
        mStructureIMD = new Segment ("IMD","", "",
                new Particle[]{
                        new Particle("F7077", getFieldF7077(), 0, 1, 1, false, new String[]{}),				new Particle("F7081", getFieldF7081(), 0, 1, 1, false, new String[]{}),				new Particle("C273", getFieldC273(), 0, 1, 1, false, new String[]{}),				new Particle("F7383", getFieldF7383(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureINP = null;
    static StructureItem getStructureINP() {  if (mStructureINP == null) initStructureINP(); return mStructureINP; }
    static void initStructureINP ()
    {
        mStructureINP = new Segment ("INP","", "",
                new Particle[]{
                        new Particle("C849", getFieldC849(), 0, 1, 1, false, new String[]{}),				new Particle("C522", getFieldC522(), 0, 1, 1, false, new String[]{}),				new Particle("C850", getFieldC850(), 0, 1, 1, false, new String[]{}),				new Particle("F1229", getFieldF1229(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureLIN = null;
    static StructureItem getStructureLIN() {  if (mStructureLIN == null) initStructureLIN(); return mStructureLIN; }
    static void initStructureLIN ()
    {
        mStructureLIN = new Segment ("LIN","", "",
                new Particle[]{
                        new Particle("F1082", getFieldF1082(), 0, 1, 1, false, new String[]{}),				new Particle("F1229", getFieldF1229(), 0, 1, 1, false, new String[]{}),				new Particle("C212", getFieldC212(), 0, 1, 1, false, new String[]{}),				new Particle("C829", getFieldC829(), 0, 1, 1, false, new String[]{}),				new Particle("F1222", getFieldF1222(), 0, 1, 1, false, new String[]{}),				new Particle("F7083", getFieldF7083(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureLOC = null;
    static StructureItem getStructureLOC() {  if (mStructureLOC == null) initStructureLOC(); return mStructureLOC; }
    static void initStructureLOC ()
    {
        mStructureLOC = new Segment ("LOC","", "",
                new Particle[]{
                        new Particle("F3227", getFieldF3227(), 1, 1, 1, false, new String[]{}),				new Particle("C517", getFieldC517(), 0, 1, 1, false, new String[]{}),				new Particle("C519", getFieldC519(), 0, 1, 1, false, new String[]{}),				new Particle("C553", getFieldC553(), 0, 1, 1, false, new String[]{}),				new Particle("F5479", getFieldF5479(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureMEA = null;
    static StructureItem getStructureMEA() {  if (mStructureMEA == null) initStructureMEA(); return mStructureMEA; }
    static void initStructureMEA ()
    {
        mStructureMEA = new Segment ("MEA","", "",
                new Particle[]{
                        new Particle("F6311", getFieldF6311(), 1, 1, 1, false, new String[]{}),				new Particle("C502", getFieldC502(), 0, 1, 1, false, new String[]{}),				new Particle("C174", getFieldC174(), 0, 1, 1, false, new String[]{}),				new Particle("F7383", getFieldF7383(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureMOA = null;
    static StructureItem getStructureMOA() {  if (mStructureMOA == null) initStructureMOA(); return mStructureMOA; }
    static void initStructureMOA ()
    {
        mStructureMOA = new Segment ("MOA","", "",
                new Particle[]{
                        new Particle("C516", getFieldC516(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureNAD = null;
    static StructureItem getStructureNAD() {  if (mStructureNAD == null) initStructureNAD(); return mStructureNAD; }
    static void initStructureNAD ()
    {
        mStructureNAD = new Segment ("NAD","", "",
                new Particle[]{
                        new Particle("F3035", getFieldF3035(), 1, 1, 1, false, new String[]{}),				new Particle("C082", getFieldC082(), 0, 1, 1, false, new String[]{}),				new Particle("C058", getFieldC058(), 0, 1, 1, false, new String[]{}),				new Particle("C080", getFieldC080(), 0, 1, 1, false, new String[]{}),				new Particle("C059", getFieldC059(), 0, 1, 1, false, new String[]{}),				new Particle("F3164", getFieldF3164(), 0, 1, 1, false, new String[]{}),				new Particle("F3229", getFieldF3229(), 0, 1, 1, false, new String[]{}),				new Particle("F3251", getFieldF3251(), 0, 1, 1, false, new String[]{}),				new Particle("F3207", getFieldF3207(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructurePAC = null;
    static StructureItem getStructurePAC() {  if (mStructurePAC == null) initStructurePAC(); return mStructurePAC; }
    static void initStructurePAC ()
    {
        mStructurePAC = new Segment ("PAC","", "",
                new Particle[]{
                        new Particle("F7224", getFieldF7224(), 0, 1, 1, false, new String[]{}),				new Particle("C531", getFieldC531(), 0, 1, 1, false, new String[]{}),				new Particle("C202", getFieldC202(), 0, 1, 1, false, new String[]{}),				new Particle("C402", getFieldC402(), 0, 1, 1, false, new String[]{}),				new Particle("C532", getFieldC532(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructurePAI = null;
    static StructureItem getStructurePAI() {  if (mStructurePAI == null) initStructurePAI(); return mStructurePAI; }
    static void initStructurePAI ()
    {
        mStructurePAI = new Segment ("PAI","", "",
                new Particle[]{
                        new Particle("C534", getFieldC534(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructurePAT = null;
    static StructureItem getStructurePAT() {  if (mStructurePAT == null) initStructurePAT(); return mStructurePAT; }
    static void initStructurePAT ()
    {
        mStructurePAT = new Segment ("PAT","", "",
                new Particle[]{
                        new Particle("F4279", getFieldF4279(), 1, 1, 1, false, new String[]{}),				new Particle("C110", getFieldC110(), 0, 1, 1, false, new String[]{}),				new Particle("C112", getFieldC112(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructurePCD = null;
    static StructureItem getStructurePCD() {  if (mStructurePCD == null) initStructurePCD(); return mStructurePCD; }
    static void initStructurePCD ()
    {
        mStructurePCD = new Segment ("PCD","", "",
                new Particle[]{
                        new Particle("C501", getFieldC501(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructurePCI = null;
    static StructureItem getStructurePCI() {  if (mStructurePCI == null) initStructurePCI(); return mStructurePCI; }
    static void initStructurePCI ()
    {
        mStructurePCI = new Segment ("PCI","", "",
                new Particle[]{
                        new Particle("F4233", getFieldF4233(), 0, 1, 1, false, new String[]{}),				new Particle("C210", getFieldC210(), 0, 1, 1, false, new String[]{}),				new Particle("F8275", getFieldF8275(), 0, 1, 1, false, new String[]{}),				new Particle("C827", getFieldC827(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructurePIA = null;
    static StructureItem getStructurePIA() {  if (mStructurePIA == null) initStructurePIA(); return mStructurePIA; }
    static void initStructurePIA ()
    {
        mStructurePIA = new Segment ("PIA","", "",
                new Particle[]{
                        new Particle("F4347", getFieldF4347(), 1, 1, 1, false, new String[]{}),				new Particle("C212", getFieldC212(), 1, 1, 5, false, new String[]{}),			});
    }

    static StructureItem mStructurePRI = null;
    static StructureItem getStructurePRI() {  if (mStructurePRI == null) initStructurePRI(); return mStructurePRI; }
    static void initStructurePRI ()
    {
        mStructurePRI = new Segment ("PRI","", "",
                new Particle[]{
                        new Particle("C509", getFieldC509(), 0, 1, 1, false, new String[]{}),				new Particle("F5213", getFieldF5213(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureQTY = null;
    static StructureItem getStructureQTY() {  if (mStructureQTY == null) initStructureQTY(); return mStructureQTY; }
    static void initStructureQTY ()
    {
        mStructureQTY = new Segment ("QTY","", "",
                new Particle[]{
                        new Particle("C186", getFieldC186(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureQVR = null;
    static StructureItem getStructureQVR() {  if (mStructureQVR == null) initStructureQVR(); return mStructureQVR; }
    static void initStructureQVR ()
    {
        mStructureQVR = new Segment ("QVR","", "",
                new Particle[]{
                        new Particle("C279", getFieldC279(), 0, 1, 1, false, new String[]{}),				new Particle("F4221", getFieldF4221(), 0, 1, 1, false, new String[]{}),				new Particle("C960", getFieldC960(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureRCS = null;
    static StructureItem getStructureRCS() {  if (mStructureRCS == null) initStructureRCS(); return mStructureRCS; }
    static void initStructureRCS ()
    {
        mStructureRCS = new Segment ("RCS","", "",
                new Particle[]{
                        new Particle("F7293", getFieldF7293(), 1, 1, 1, false, new String[]{}),				new Particle("C550", getFieldC550(), 0, 1, 1, false, new String[]{}),				new Particle("F1229", getFieldF1229(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureRFF = null;
    static StructureItem getStructureRFF() {  if (mStructureRFF == null) initStructureRFF(); return mStructureRFF; }
    static void initStructureRFF ()
    {
        mStructureRFF = new Segment ("RFF","", "",
                new Particle[]{
                        new Particle("C506", getFieldC506(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureRNG = null;
    static StructureItem getStructureRNG() {  if (mStructureRNG == null) initStructureRNG(); return mStructureRNG; }
    static void initStructureRNG ()
    {
        mStructureRNG = new Segment ("RNG","", "",
                new Particle[]{
                        new Particle("F6167", getFieldF6167(), 1, 1, 1, false, new String[]{}),				new Particle("C280", getFieldC280(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureRTE = null;
    static StructureItem getStructureRTE() {  if (mStructureRTE == null) initStructureRTE(); return mStructureRTE; }
    static void initStructureRTE ()
    {
        mStructureRTE = new Segment ("RTE","", "",
                new Particle[]{
                        new Particle("C128", getFieldC128(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTAX = null;
    static StructureItem getStructureTAX() {  if (mStructureTAX == null) initStructureTAX(); return mStructureTAX; }
    static void initStructureTAX ()
    {
        mStructureTAX = new Segment ("TAX","", "",
                new Particle[]{
                        new Particle("F5283", getFieldF5283(), 1, 1, 1, false, new String[]{}),				new Particle("C241", getFieldC241(), 0, 1, 1, false, new String[]{}),				new Particle("C533", getFieldC533(), 0, 1, 1, false, new String[]{}),				new Particle("F5286", getFieldF5286(), 0, 1, 1, false, new String[]{}),				new Particle("C243", getFieldC243(), 0, 1, 1, false, new String[]{}),				new Particle("F5305", getFieldF5305(), 0, 1, 1, false, new String[]{}),				new Particle("F3446", getFieldF3446(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTDT = null;
    static StructureItem getStructureTDT() {  if (mStructureTDT == null) initStructureTDT(); return mStructureTDT; }
    static void initStructureTDT ()
    {
        mStructureTDT = new Segment ("TDT","", "",
                new Particle[]{
                        new Particle("F8051", getFieldF8051(), 1, 1, 1, false, new String[]{}),				new Particle("F8028", getFieldF8028(), 0, 1, 1, false, new String[]{}),				new Particle("C220", getFieldC220(), 0, 1, 1, false, new String[]{}),				new Particle("C228", getFieldC228(), 0, 1, 1, false, new String[]{}),				new Particle("C040", getFieldC040(), 0, 1, 1, false, new String[]{}),				new Particle("F8101", getFieldF8101(), 0, 1, 1, false, new String[]{}),				new Particle("C401", getFieldC401(), 0, 1, 1, false, new String[]{}),				new Particle("C222", getFieldC222(), 0, 1, 1, false, new String[]{}),				new Particle("F8281", getFieldF8281(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTOD = null;
    static StructureItem getStructureTOD() {  if (mStructureTOD == null) initStructureTOD(); return mStructureTOD; }
    static void initStructureTOD ()
    {
        mStructureTOD = new Segment ("TOD","", "",
                new Particle[]{
                        new Particle("F4055", getFieldF4055(), 0, 1, 1, false, new String[]{}),				new Particle("F4215", getFieldF4215(), 0, 1, 1, false, new String[]{}),				new Particle("C100", getFieldC100(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureUNA = null;
    static StructureItem getStructureUNA() {  if (mStructureUNA == null) initStructureUNA(); return mStructureUNA; }
    static void initStructureUNA ()
    {
        mStructureUNA = new Segment ("UNA","", "",
                new Particle[]{
                });
    }

    static StructureItem mStructureUNB = null;
    static StructureItem getStructureUNB() {  if (mStructureUNB == null) initStructureUNB(); return mStructureUNB; }
    static void initStructureUNB ()
    {
        mStructureUNB = new Segment ("UNB","", "",
                new Particle[]{
                        new Particle("S001", getFieldS001(), 1, 1, 1, false, new String[]{}),				new Particle("S002", getFieldS002(), 1, 1, 1, false, new String[]{}),				new Particle("S003", getFieldS003(), 1, 1, 1, false, new String[]{}),				new Particle("S004", getFieldS004(), 1, 1, 1, false, new String[]{}),				new Particle("F0020", getFieldF0020(), 1, 1, 1, false, new String[]{}),				new Particle("S005", getFieldS005(), 0, 1, 1, false, new String[]{}),				new Particle("F0026", getFieldF0026(), 0, 1, 1, false, new String[]{}),				new Particle("F0029", getFieldF0029(), 0, 1, 1, false, new String[]{}),				new Particle("F0031", getFieldF0031(), 0, 1, 1, false, new String[]{}),				new Particle("F0032", getFieldF0032(), 0, 1, 1, false, new String[]{}),				new Particle("F0035", getFieldF0035(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureUNE = null;
    static StructureItem getStructureUNE() {  if (mStructureUNE == null) initStructureUNE(); return mStructureUNE; }
    static void initStructureUNE ()
    {
        mStructureUNE = new Segment ("UNE","", "",
                new Particle[]{
                        new Particle("F0060", getFieldF0060(), 1, 1, 1, false, new String[]{}),				new Particle("F0048", getFieldF0048(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureUNG = null;
    static StructureItem getStructureUNG() {  if (mStructureUNG == null) initStructureUNG(); return mStructureUNG; }
    static void initStructureUNG ()
    {
        mStructureUNG = new Segment ("UNG","", "",
                new Particle[]{
                        new Particle("F0038", getFieldF0038(), 0, 1, 1, false, new String[]{}),				new Particle("S006", getFieldS006(), 0, 1, 1, false, new String[]{}),				new Particle("S007", getFieldS007(), 0, 1, 1, false, new String[]{}),				new Particle("S004", getFieldS004(), 0, 1, 1, false, new String[]{}),				new Particle("F0048", getFieldF0048(), 1, 1, 1, false, new String[]{}),				new Particle("F0051", getFieldF0051(), 0, 1, 1, false, new String[]{}),				new Particle("S008", getFieldS008(), 0, 1, 1, false, new String[]{}),				new Particle("F0058", getFieldF0058(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureUNH = null;
    static StructureItem getStructureUNH() {  if (mStructureUNH == null) initStructureUNH(); return mStructureUNH; }
    static void initStructureUNH ()
    {
        mStructureUNH = new Segment ("UNH","", "",
                new Particle[]{
                        new Particle("F0062", getFieldF0062(), 1, 1, 1, false, new String[]{}),				new Particle("S009", getFieldS009(), 1, 1, 1, false, new String[]{}),				new Particle("F0068", getFieldF0068(), 0, 1, 1, false, new String[]{}),				new Particle("S010", getFieldS010(), 0, 1, 1, false, new String[]{}),				new Particle("S016", getFieldS016(), 0, 1, 1, false, new String[]{}),				new Particle("S017", getFieldS017(), 0, 1, 1, false, new String[]{}),				new Particle("S018", getFieldS018(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureUNS = null;
    static StructureItem getStructureUNS() {  if (mStructureUNS == null) initStructureUNS(); return mStructureUNS; }
    static void initStructureUNS ()
    {
        mStructureUNS = new Segment ("UNS","", "",
                new Particle[]{
                        new Particle("F0081", getFieldF0081(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureUNT = null;
    static StructureItem getStructureUNT() {  if (mStructureUNT == null) initStructureUNT(); return mStructureUNT; }
    static void initStructureUNT ()
    {
        mStructureUNT = new Segment ("UNT","", "",
                new Particle[]{
                        new Particle("F0074", getFieldF0074(), 1, 1, 1, false, new String[]{}),				new Particle("F0062", getFieldF0062(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureUNZ = null;
    static StructureItem getStructureUNZ() {  if (mStructureUNZ == null) initStructureUNZ(); return mStructureUNZ; }
    static void initStructureUNZ ()
    {
        mStructureUNZ = new Segment ("UNZ","", "",
                new Particle[]{
                        new Particle("F0036", getFieldF0036(), 1, 1, 1, false, new String[]{}),				new Particle("F0020", getFieldF0020(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureEnvelope = null;
    static StructureItem getStructureEnvelope() {  if (mStructureEnvelope == null) initStructureEnvelope(); return mStructureEnvelope; }
    static void initStructureEnvelope ()
    {
        mStructureEnvelope = new Group ("Envelope","", "",
                new Particle[]{
                        new Particle("Interchange", getStructureInterchange(), 1, Integer.MAX_VALUE, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureGroup = null;
    static StructureItem getStructureGroup() {  if (mStructureGroup == null) initStructureGroup(); return mStructureGroup; }
    static void initStructureGroup ()
    {
        mStructureGroup = new Group ("Group","", "",
                new Particle[]{
                        new Particle("UNG", getStructureUNG(), 0, 1, 1, false, new String[]{}),				new Particle("Select", getStructureSelect(), 1, Integer.MAX_VALUE, 1, false, new String[]{}),				new Particle("UNE", getStructureUNE(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureInterchange = null;
    static StructureItem getStructureInterchange() {  if (mStructureInterchange == null) initStructureInterchange(); return mStructureInterchange; }
    static void initStructureInterchange ()
    {
        mStructureInterchange = new Group ("Interchange","", "",
                new Particle[]{
                        new Particle("UNA", getStructureUNA(), 0, 1, 1, false, new String[]{}),				new Particle("UNB", getStructureUNB(), 0, 1, 1, false, new String[]{}),				new Particle("Group", getStructureGroup(), 1, Integer.MAX_VALUE, 1, false, new String[]{}),				new Particle("UNZ", getStructureUNZ(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureMessage_INVOIC = null;
    static StructureItem getStructureMessage_INVOIC() {  if (mStructureMessage_INVOIC == null) initStructureMessage_INVOIC(); return mStructureMessage_INVOIC; }
    static void initStructureMessage_INVOIC ()
    {
        mStructureMessage_INVOIC = new Group ("Message_INVOIC","", "",
                new Particle[]{
                        new Particle("UNH", getStructureUNH(), 1, 1, 1, false, new String[]{}),				new Particle("BGM", getStructureBGM(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 1, 35, 1, false, new String[]{}),				new Particle("PAI", getStructurePAI(), 0, 1, 1, false, new String[]{}),				new Particle("ALI", getStructureALI(), 0, 5, 1, false, new String[]{}),				new Particle("IMD", getStructureIMD(), 0, 1, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 10, 1, false, new String[]{}),				new Particle("SG1", getStructureSG1(), 0, 99, 1, false, new String[]{}),				new Particle("SG2", getStructureSG2(), 0, 99, 1, false, new String[]{}),				new Particle("SG6", getStructureSG6(), 0, 5, 1, false, new String[]{}),				new Particle("SG7", getStructureSG7(), 0, 5, 1, false, new String[]{}),				new Particle("SG8", getStructureSG8(), 0, 10, 1, false, new String[]{}),				new Particle("SG9", getStructureSG9(), 0, 10, 1, false, new String[]{}),				new Particle("SG12", getStructureSG12(), 0, 5, 1, false, new String[]{}),				new Particle("SG13", getStructureSG13(), 0, 1000, 1, false, new String[]{}),				new Particle("SG15", getStructureSG15(), 0, 9999, 1, false, new String[]{}),				new Particle("SG22", getStructureSG22(), 0, 100, 1, false, new String[]{}),				new Particle("SG23", getStructureSG23(), 0, 1, 1, false, new String[]{}),				new Particle("SG24", getStructureSG24(), 0, 1, 1, false, new String[]{}),				new Particle("SG25", getStructureSG25(), 0, 9999999, 1, false, new String[]{}),				new Particle("UNS", getStructureUNS(), 1, 1, 1, false, new String[]{}),				new Particle("CNT", getStructureCNT(), 0, 10, 1, false, new String[]{}),				new Particle("SG48", getStructureSG48(), 1, 100, 1, false, new String[]{}),				new Particle("SG50", getStructureSG50(), 0, 10, 1, false, new String[]{}),				new Particle("SG51", getStructureSG51(), 0, 15, 1, false, new String[]{}),				new Particle("UNT", getStructureUNT(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG1 = null;
    static StructureItem getStructureSG1() {  if (mStructureSG1 == null) initStructureSG1(); return mStructureSG1; }
    static void initStructureSG1 ()
    {
        mStructureSG1 = new Group ("SG1","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG10 = null;
    static StructureItem getStructureSG10() {  if (mStructureSG10 == null) initStructureSG10(); return mStructureSG10; }
    static void initStructureSG10 ()
    {
        mStructureSG10 = new Group ("SG10","", "",
                new Particle[]{
                        new Particle("LOC", getStructureLOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG11 = null;
    static StructureItem getStructureSG11() {  if (mStructureSG11 == null) initStructureSG11(); return mStructureSG11; }
    static void initStructureSG11 ()
    {
        mStructureSG11 = new Group ("SG11","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG12 = null;
    static StructureItem getStructureSG12() {  if (mStructureSG12 == null) initStructureSG12(); return mStructureSG12; }
    static void initStructureSG12 ()
    {
        mStructureSG12 = new Group ("SG12","", "",
                new Particle[]{
                        new Particle("TOD", getStructureTOD(), 1, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 2, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG13 = null;
    static StructureItem getStructureSG13() {  if (mStructureSG13 == null) initStructureSG13(); return mStructureSG13; }
    static void initStructureSG13 ()
    {
        mStructureSG13 = new Group ("SG13","", "",
                new Particle[]{
                        new Particle("PAC", getStructurePAC(), 1, 1, 1, false, new String[]{}),				new Particle("MEA", getStructureMEA(), 0, 5, 1, false, new String[]{}),				new Particle("SG14", getStructureSG14(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG14 = null;
    static StructureItem getStructureSG14() {  if (mStructureSG14 == null) initStructureSG14(); return mStructureSG14; }
    static void initStructureSG14 ()
    {
        mStructureSG14 = new Group ("SG14","", "",
                new Particle[]{
                        new Particle("PCI", getStructurePCI(), 1, 1, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),				new Particle("GIN", getStructureGIN(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG15 = null;
    static StructureItem getStructureSG15() {  if (mStructureSG15 == null) initStructureSG15(); return mStructureSG15; }
    static void initStructureSG15 ()
    {
        mStructureSG15 = new Group ("SG15","", "",
                new Particle[]{
                        new Particle("ALC", getStructureALC(), 1, 1, 1, false, new String[]{}),				new Particle("ALI", getStructureALI(), 0, 5, 1, false, new String[]{}),				new Particle("SG16", getStructureSG16(), 0, 5, 1, false, new String[]{}),				new Particle("SG17", getStructureSG17(), 0, 1, 1, false, new String[]{}),				new Particle("SG18", getStructureSG18(), 0, 1, 1, false, new String[]{}),				new Particle("SG19", getStructureSG19(), 0, 2, 1, false, new String[]{}),				new Particle("SG20", getStructureSG20(), 0, 1, 1, false, new String[]{}),				new Particle("SG21", getStructureSG21(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG16 = null;
    static StructureItem getStructureSG16() {  if (mStructureSG16 == null) initStructureSG16(); return mStructureSG16; }
    static void initStructureSG16 ()
    {
        mStructureSG16 = new Group ("SG16","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG17 = null;
    static StructureItem getStructureSG17() {  if (mStructureSG17 == null) initStructureSG17(); return mStructureSG17; }
    static void initStructureSG17 ()
    {
        mStructureSG17 = new Group ("SG17","", "",
                new Particle[]{
                        new Particle("QTY", getStructureQTY(), 1, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG18 = null;
    static StructureItem getStructureSG18() {  if (mStructureSG18 == null) initStructureSG18(); return mStructureSG18; }
    static void initStructureSG18 ()
    {
        mStructureSG18 = new Group ("SG18","", "",
                new Particle[]{
                        new Particle("PCD", getStructurePCD(), 1, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG19 = null;
    static StructureItem getStructureSG19() {  if (mStructureSG19 == null) initStructureSG19(); return mStructureSG19; }
    static void initStructureSG19 ()
    {
        mStructureSG19 = new Group ("SG19","", "",
                new Particle[]{
                        new Particle("MOA", getStructureMOA(), 1, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG2 = null;
    static StructureItem getStructureSG2() {  if (mStructureSG2 == null) initStructureSG2(); return mStructureSG2; }
    static void initStructureSG2 ()
    {
        mStructureSG2 = new Group ("SG2","", "",
                new Particle[]{
                        new Particle("NAD", getStructureNAD(), 1, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 25, 1, false, new String[]{}),				new Particle("FII", getStructureFII(), 0, 5, 1, false, new String[]{}),				new Particle("SG3", getStructureSG3(), 0, 9999, 1, false, new String[]{}),				new Particle("SG4", getStructureSG4(), 0, 5, 1, false, new String[]{}),				new Particle("SG5", getStructureSG5(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG20 = null;
    static StructureItem getStructureSG20() {  if (mStructureSG20 == null) initStructureSG20(); return mStructureSG20; }
    static void initStructureSG20 ()
    {
        mStructureSG20 = new Group ("SG20","", "",
                new Particle[]{
                        new Particle("RTE", getStructureRTE(), 1, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG21 = null;
    static StructureItem getStructureSG21() {  if (mStructureSG21 == null) initStructureSG21(); return mStructureSG21; }
    static void initStructureSG21 ()
    {
        mStructureSG21 = new Group ("SG21","", "",
                new Particle[]{
                        new Particle("TAX", getStructureTAX(), 1, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG22 = null;
    static StructureItem getStructureSG22() {  if (mStructureSG22 == null) initStructureSG22(); return mStructureSG22; }
    static void initStructureSG22 ()
    {
        mStructureSG22 = new Group ("SG22","", "",
                new Particle[]{
                        new Particle("RCS", getStructureRCS(), 1, 1, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 5, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG23 = null;
    static StructureItem getStructureSG23() {  if (mStructureSG23 == null) initStructureSG23(); return mStructureSG23; }
    static void initStructureSG23 ()
    {
        mStructureSG23 = new Group ("SG23","", "",
                new Particle[]{
                        new Particle("AJT", getStructureAJT(), 1, 1, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG24 = null;
    static StructureItem getStructureSG24() {  if (mStructureSG24 == null) initStructureSG24(); return mStructureSG24; }
    static void initStructureSG24 ()
    {
        mStructureSG24 = new Group ("SG24","", "",
                new Particle[]{
                        new Particle("INP", getStructureINP(), 1, 1, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG25 = null;
    static StructureItem getStructureSG25() {  if (mStructureSG25 == null) initStructureSG25(); return mStructureSG25; }
    static void initStructureSG25 ()
    {
        mStructureSG25 = new Group ("SG25","", "",
                new Particle[]{
                        new Particle("LIN", getStructureLIN(), 1, 1, 1, false, new String[]{}),				new Particle("PIA", getStructurePIA(), 0, 25, 1, false, new String[]{}),				new Particle("IMD", getStructureIMD(), 0, 10, 1, false, new String[]{}),				new Particle("MEA", getStructureMEA(), 0, 5, 1, false, new String[]{}),				new Particle("QTY", getStructureQTY(), 0, 5, 1, false, new String[]{}),				new Particle("PCD", getStructurePCD(), 0, 1, 1, false, new String[]{}),				new Particle("ALI", getStructureALI(), 0, 5, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 35, 1, false, new String[]{}),				new Particle("GIN", getStructureGIN(), 0, 1000, 1, false, new String[]{}),				new Particle("GIR", getStructureGIR(), 0, 1000, 1, false, new String[]{}),				new Particle("QVR", getStructureQVR(), 0, 1, 1, false, new String[]{}),				new Particle("EQD", getStructureEQD(), 0, 1, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 5, 1, false, new String[]{}),				new Particle("SG26", getStructureSG26(), 0, 5, 1, false, new String[]{}),				new Particle("SG27", getStructureSG27(), 0, 10, 1, false, new String[]{}),				new Particle("SG28", getStructureSG28(), 0, 25, 1, false, new String[]{}),				new Particle("SG29", getStructureSG29(), 0, 10, 1, false, new String[]{}),				new Particle("SG30", getStructureSG30(), 0, 10, 1, false, new String[]{}),				new Particle("SG32", getStructureSG32(), 0, 9999, 1, false, new String[]{}),				new Particle("SG33", getStructureSG33(), 0, 99, 1, false, new String[]{}),				new Particle("SG34", getStructureSG34(), 0, 20, 1, false, new String[]{}),				new Particle("SG38", getStructureSG38(), 0, 15, 1, false, new String[]{}),				new Particle("SG44", getStructureSG44(), 0, 10, 1, false, new String[]{}),				new Particle("SG46", getStructureSG46(), 0, 5, 1, false, new String[]{}),				new Particle("SG47", getStructureSG47(), 0, 100, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG26 = null;
    static StructureItem getStructureSG26() {  if (mStructureSG26 == null) initStructureSG26(); return mStructureSG26; }
    static void initStructureSG26 ()
    {
        mStructureSG26 = new Group ("SG26","", "",
                new Particle[]{
                        new Particle("MOA", getStructureMOA(), 1, 1, 1, false, new String[]{}),				new Particle("CUX", getStructureCUX(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG27 = null;
    static StructureItem getStructureSG27() {  if (mStructureSG27 == null) initStructureSG27(); return mStructureSG27; }
    static void initStructureSG27 ()
    {
        mStructureSG27 = new Group ("SG27","", "",
                new Particle[]{
                        new Particle("PAT", getStructurePAT(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),				new Particle("PCD", getStructurePCD(), 0, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG28 = null;
    static StructureItem getStructureSG28() {  if (mStructureSG28 == null) initStructureSG28(); return mStructureSG28; }
    static void initStructureSG28 ()
    {
        mStructureSG28 = new Group ("SG28","", "",
                new Particle[]{
                        new Particle("PRI", getStructurePRI(), 1, 1, 1, false, new String[]{}),				new Particle("APR", getStructureAPR(), 0, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG29 = null;
    static StructureItem getStructureSG29() {  if (mStructureSG29 == null) initStructureSG29(); return mStructureSG29; }
    static void initStructureSG29 ()
    {
        mStructureSG29 = new Group ("SG29","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG3 = null;
    static StructureItem getStructureSG3() {  if (mStructureSG3 == null) initStructureSG3(); return mStructureSG3; }
    static void initStructureSG3 ()
    {
        mStructureSG3 = new Group ("SG3","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG30 = null;
    static StructureItem getStructureSG30() {  if (mStructureSG30 == null) initStructureSG30(); return mStructureSG30; }
    static void initStructureSG30 ()
    {
        mStructureSG30 = new Group ("SG30","", "",
                new Particle[]{
                        new Particle("PAC", getStructurePAC(), 1, 1, 1, false, new String[]{}),				new Particle("MEA", getStructureMEA(), 0, 10, 1, false, new String[]{}),				new Particle("SG31", getStructureSG31(), 0, 10, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG31 = null;
    static StructureItem getStructureSG31() {  if (mStructureSG31 == null) initStructureSG31(); return mStructureSG31; }
    static void initStructureSG31 ()
    {
        mStructureSG31 = new Group ("SG31","", "",
                new Particle[]{
                        new Particle("PCI", getStructurePCI(), 1, 1, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),				new Particle("GIN", getStructureGIN(), 0, 10, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG32 = null;
    static StructureItem getStructureSG32() {  if (mStructureSG32 == null) initStructureSG32(); return mStructureSG32; }
    static void initStructureSG32 ()
    {
        mStructureSG32 = new Group ("SG32","", "",
                new Particle[]{
                        new Particle("LOC", getStructureLOC(), 1, 1, 1, false, new String[]{}),				new Particle("QTY", getStructureQTY(), 0, 100, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG33 = null;
    static StructureItem getStructureSG33() {  if (mStructureSG33 == null) initStructureSG33(); return mStructureSG33; }
    static void initStructureSG33 ()
    {
        mStructureSG33 = new Group ("SG33","", "",
                new Particle[]{
                        new Particle("TAX", getStructureTAX(), 1, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG34 = null;
    static StructureItem getStructureSG34() {  if (mStructureSG34 == null) initStructureSG34(); return mStructureSG34; }
    static void initStructureSG34 ()
    {
        mStructureSG34 = new Group ("SG34","", "",
                new Particle[]{
                        new Particle("NAD", getStructureNAD(), 1, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 5, 1, false, new String[]{}),				new Particle("SG35", getStructureSG35(), 0, 5, 1, false, new String[]{}),				new Particle("SG36", getStructureSG36(), 0, 5, 1, false, new String[]{}),				new Particle("SG37", getStructureSG37(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG35 = null;
    static StructureItem getStructureSG35() {  if (mStructureSG35 == null) initStructureSG35(); return mStructureSG35; }
    static void initStructureSG35 ()
    {
        mStructureSG35 = new Group ("SG35","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG36 = null;
    static StructureItem getStructureSG36() {  if (mStructureSG36 == null) initStructureSG36(); return mStructureSG36; }
    static void initStructureSG36 ()
    {
        mStructureSG36 = new Group ("SG36","", "",
                new Particle[]{
                        new Particle("DOC", getStructureDOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG37 = null;
    static StructureItem getStructureSG37() {  if (mStructureSG37 == null) initStructureSG37(); return mStructureSG37; }
    static void initStructureSG37 ()
    {
        mStructureSG37 = new Group ("SG37","", "",
                new Particle[]{
                        new Particle("CTA", getStructureCTA(), 1, 1, 1, false, new String[]{}),				new Particle("COM", getStructureCOM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG38 = null;
    static StructureItem getStructureSG38() {  if (mStructureSG38 == null) initStructureSG38(); return mStructureSG38; }
    static void initStructureSG38 ()
    {
        mStructureSG38 = new Group ("SG38","", "",
                new Particle[]{
                        new Particle("ALC", getStructureALC(), 1, 1, 1, false, new String[]{}),				new Particle("ALI", getStructureALI(), 0, 5, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),				new Particle("SG39", getStructureSG39(), 0, 1, 1, false, new String[]{}),				new Particle("SG40", getStructureSG40(), 0, 1, 1, false, new String[]{}),				new Particle("SG41", getStructureSG41(), 0, 2, 1, false, new String[]{}),				new Particle("SG42", getStructureSG42(), 0, 1, 1, false, new String[]{}),				new Particle("SG43", getStructureSG43(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG39 = null;
    static StructureItem getStructureSG39() {  if (mStructureSG39 == null) initStructureSG39(); return mStructureSG39; }
    static void initStructureSG39 ()
    {
        mStructureSG39 = new Group ("SG39","", "",
                new Particle[]{
                        new Particle("QTY", getStructureQTY(), 1, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG4 = null;
    static StructureItem getStructureSG4() {  if (mStructureSG4 == null) initStructureSG4(); return mStructureSG4; }
    static void initStructureSG4 ()
    {
        mStructureSG4 = new Group ("SG4","", "",
                new Particle[]{
                        new Particle("DOC", getStructureDOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG40 = null;
    static StructureItem getStructureSG40() {  if (mStructureSG40 == null) initStructureSG40(); return mStructureSG40; }
    static void initStructureSG40 ()
    {
        mStructureSG40 = new Group ("SG40","", "",
                new Particle[]{
                        new Particle("PCD", getStructurePCD(), 1, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG41 = null;
    static StructureItem getStructureSG41() {  if (mStructureSG41 == null) initStructureSG41(); return mStructureSG41; }
    static void initStructureSG41 ()
    {
        mStructureSG41 = new Group ("SG41","", "",
                new Particle[]{
                        new Particle("MOA", getStructureMOA(), 1, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG42 = null;
    static StructureItem getStructureSG42() {  if (mStructureSG42 == null) initStructureSG42(); return mStructureSG42; }
    static void initStructureSG42 ()
    {
        mStructureSG42 = new Group ("SG42","", "",
                new Particle[]{
                        new Particle("RTE", getStructureRTE(), 1, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG43 = null;
    static StructureItem getStructureSG43() {  if (mStructureSG43 == null) initStructureSG43(); return mStructureSG43; }
    static void initStructureSG43 ()
    {
        mStructureSG43 = new Group ("SG43","", "",
                new Particle[]{
                        new Particle("TAX", getStructureTAX(), 1, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG44 = null;
    static StructureItem getStructureSG44() {  if (mStructureSG44 == null) initStructureSG44(); return mStructureSG44; }
    static void initStructureSG44 ()
    {
        mStructureSG44 = new Group ("SG44","", "",
                new Particle[]{
                        new Particle("TDT", getStructureTDT(), 1, 1, 1, false, new String[]{}),				new Particle("SG45", getStructureSG45(), 0, 10, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG45 = null;
    static StructureItem getStructureSG45() {  if (mStructureSG45 == null) initStructureSG45(); return mStructureSG45; }
    static void initStructureSG45 ()
    {
        mStructureSG45 = new Group ("SG45","", "",
                new Particle[]{
                        new Particle("LOC", getStructureLOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG46 = null;
    static StructureItem getStructureSG46() {  if (mStructureSG46 == null) initStructureSG46(); return mStructureSG46; }
    static void initStructureSG46 ()
    {
        mStructureSG46 = new Group ("SG46","", "",
                new Particle[]{
                        new Particle("TOD", getStructureTOD(), 1, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 2, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG47 = null;
    static StructureItem getStructureSG47() {  if (mStructureSG47 == null) initStructureSG47(); return mStructureSG47; }
    static void initStructureSG47 ()
    {
        mStructureSG47 = new Group ("SG47","", "",
                new Particle[]{
                        new Particle("RCS", getStructureRCS(), 1, 1, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 5, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG48 = null;
    static StructureItem getStructureSG48() {  if (mStructureSG48 == null) initStructureSG48(); return mStructureSG48; }
    static void initStructureSG48 ()
    {
        mStructureSG48 = new Group ("SG48","", "",
                new Particle[]{
                        new Particle("MOA", getStructureMOA(), 1, 1, 1, false, new String[]{}),				new Particle("SG49", getStructureSG49(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG49 = null;
    static StructureItem getStructureSG49() {  if (mStructureSG49 == null) initStructureSG49(); return mStructureSG49; }
    static void initStructureSG49 ()
    {
        mStructureSG49 = new Group ("SG49","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG5 = null;
    static StructureItem getStructureSG5() {  if (mStructureSG5 == null) initStructureSG5(); return mStructureSG5; }
    static void initStructureSG5 ()
    {
        mStructureSG5 = new Group ("SG5","", "",
                new Particle[]{
                        new Particle("CTA", getStructureCTA(), 1, 1, 1, false, new String[]{}),				new Particle("COM", getStructureCOM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG50 = null;
    static StructureItem getStructureSG50() {  if (mStructureSG50 == null) initStructureSG50(); return mStructureSG50; }
    static void initStructureSG50 ()
    {
        mStructureSG50 = new Group ("SG50","", "",
                new Particle[]{
                        new Particle("TAX", getStructureTAX(), 1, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 2, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG51 = null;
    static StructureItem getStructureSG51() {  if (mStructureSG51 == null) initStructureSG51(); return mStructureSG51; }
    static void initStructureSG51 ()
    {
        mStructureSG51 = new Group ("SG51","", "",
                new Particle[]{
                        new Particle("ALC", getStructureALC(), 1, 1, 1, false, new String[]{}),				new Particle("ALI", getStructureALI(), 0, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 2, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG6 = null;
    static StructureItem getStructureSG6() {  if (mStructureSG6 == null) initStructureSG6(); return mStructureSG6; }
    static void initStructureSG6 ()
    {
        mStructureSG6 = new Group ("SG6","", "",
                new Particle[]{
                        new Particle("TAX", getStructureTAX(), 1, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG7 = null;
    static StructureItem getStructureSG7() {  if (mStructureSG7 == null) initStructureSG7(); return mStructureSG7; }
    static void initStructureSG7 ()
    {
        mStructureSG7 = new Group ("SG7","", "",
                new Particle[]{
                        new Particle("CUX", getStructureCUX(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG8 = null;
    static StructureItem getStructureSG8() {  if (mStructureSG8 == null) initStructureSG8(); return mStructureSG8; }
    static void initStructureSG8 ()
    {
        mStructureSG8 = new Group ("SG8","", "",
                new Particle[]{
                        new Particle("PAT", getStructurePAT(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 5, 1, false, new String[]{}),				new Particle("PCD", getStructurePCD(), 0, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 1, 1, false, new String[]{}),				new Particle("PAI", getStructurePAI(), 0, 1, 1, false, new String[]{}),				new Particle("FII", getStructureFII(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG9 = null;
    static StructureItem getStructureSG9() {  if (mStructureSG9 == null) initStructureSG9(); return mStructureSG9; }
    static void initStructureSG9 ()
    {
        mStructureSG9 = new Group ("SG9","", "",
                new Particle[]{
                        new Particle("TDT", getStructureTDT(), 1, 1, 1, false, new String[]{}),				new Particle("SG10", getStructureSG10(), 0, 10, 1, false, new String[]{}),				new Particle("SG11", getStructureSG11(), 0, 9999, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSelect = null;
    static StructureItem getStructureSelect() {  if (mStructureSelect == null) initStructureSelect(); return mStructureSelect; }
    static void initStructureSelect ()
    {
        mStructureSelect = new Select ("Select","Message_","UNH/S009/F0065","Group",
                new Particle[]{
                        new Particle("UNH", getStructureUNH(), 1, 1, 1, false, new String[]{}),			});
    }
    static Particle rootParticle = new Particle (null, getStructureEnvelope(), 1, 1, 1, false, new String[]{});

    private void initSegmentVectors()
    {
        String[] arStandardSegments = new String[] { "ADR","AGR","AJT","ALC","ALI","APR","ARD","ARR","ASI","ATT","AUT","BGM","BII","BUS","CAV","CCD","CCI","CDI","CDS","CDV","CED","CMP","CNI","CNT","COD","COM","COT","CPI","CPS","CST","CTA","CUX","DAM","DGS","DII","DIM","DLI","DLM","DMS","DOC","DSI","DTM","EFI","ELM","ELU","EMP","EQA","EQD","EQN","ERC","ERP","FCA","FII","FNS","FNT","FTX","GDS","GID","GIN","GIR","GIS","GOR","GRU","HAN","ICD","IDE","IHC","IMD","IND","INP","INV","IRQ","LAN","LIN","LOC","MEA","MEM","MKS","MOA","MSG","NAD","NAT","PAC","PAI","PAT","PCD","PCI","PDI","PGI","PIA","PIT","PNA","PRC","PRI","PSD","PTY","QTY","QVR","RCS","REL","RFF","RNG","RTE","SAL","SCC","SCD","SEG","SEL","SEQ","SFI","SGP","SGU","SPS","STA","STC","STG","STS","TAX","TCC","TDT","TEM","TMD","TMP","TOD","TPL","TSR","UCD","UCF","UCI","UCM","UCS","UGH","UGT","UIB","UIH","UIR","UIT","UIZ","UNA","UNB","UNE","UNG","UNH","UNO","UNP","UNS","UNT","UNZ","USA","USB","USC","USD","USE","USF","USH","USL","USR","UST","USU","USX","USY","VLI" };
        StandardSegments.addAll( java.util.Arrays.asList( arStandardSegments) );

        String[] arINVOICSegments = new String[] { "AJT","ALC","ALI","APR","BGM","CNT","COM","CTA","CUX","DOC","DTM","EQD","FII","FTX","GIN","GIR","IMD","INP","LIN","LOC","MEA","MOA","NAD","PAC","PAI","PAT","PCD","PCI","PIA","PRI","QTY","QVR","RCS","RFF","RNG","RTE","TAX","TDT","TOD","UNH","UNS","UNT" };
        mMessages.put( "INVOIC", new Message( "INVOIC", new Particle("Message_INVOIC", getStructureMessage_INVOIC(), 1,1,1, false, new String[]{}), new java.util.HashSet<String>( java.util.Arrays.asList( arINVOICSegments) ), 0, 0, 0 ) );
    }

    public INVOICD96AEnvelope()
    {
        super(rootParticle);
        initSettings();
        initSegmentVectors();
    }

    void recordDecimalSeparator()
    {
        //super.getGenerator().RootNode.DecimalSeparator= super.Scanner.DecimalSeparator;
    }

    protected  boolean validateSource(StringBuffer buffer)
    {
        return true;
    }
    protected  boolean validateResult()
    {
        boolean result = super.validateResult();
        this.recordDecimalSeparator();
        return result;
    }

    protected void initSettings()
    {
        super.setStructureName("INVOIC");

        super.mSettings = new EDIFactSettings();
        // EDIFact specific settings:

        ((EDIFactSettings)super.mSettings).setSyntaxLevel('A');

        ((EDIFactSettings)super.mSettings).setSyntaxVersionNumber(4);

        ((EDIFactSettings)super.mSettings).setControllingAgency("UNO");

        ((EDIFactSettings)super.mSettings).setWriteUNA(true);

        // general settings:
        super.mSettings.setMessageType("INVOIC");
        super.mSettings.setLineEnd(0);
        super.mSettings.setAutoCompleteData(true);
        super.mSettings.setTerminateSegmentsWithLinefeed(true);

        super.mSettings.setVersion("D");

        super.mSettings.setRelease("96A");

        ServiceChars serviceChars = mSettings.getServiceChars();
        serviceChars.setComponentSeparator(':');
        serviceChars.setDataElementSeparator('+');
        serviceChars.setDecimalSeparator('.');
        serviceChars.setReleaseCharacter('?');
        serviceChars.setSegmentSeparator('+');
        serviceChars.setSegmentTerminator('\'');
        serviceChars.setRepetitionSeparator('*');
        serviceChars.setSubComponentSeparator('\0');

        // Error handling settings
        Action[] arValidationSettings = {
                Action.Stop,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,
                Action.ReportAccept,

        };
        setErrorSettings( arValidationSettings);
    }
}
