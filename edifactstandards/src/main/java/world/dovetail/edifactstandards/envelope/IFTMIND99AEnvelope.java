package world.dovetail.edifactstandards.envelope;

import world.dovetail.edifactcommon.text.edi.*;

public class IFTMIND99AEnvelope extends TextDocument
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
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","137","138","139","140","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","220","221","222","223","224","225","226","227","228","229","230","231","232","233","234","235","236","237","238","239","240","241","242","243","244","245","246","247","248","249","250","251","252","253","254","255","256","257","258","259","260","261","262","263","264","265","266","267","268","269","270","271","272","273","274","275","276","277","278","279","280","281","282","283","284","285","286","287","288","289","290","291","292","293","294","295","296","297","298","299","300","301","302","310","311","315","320","325","326","327","328","330","335","340","341","343","345","350","351","370","380","381","382","383","384","385","386","387","388","389","390","393","394","395","396","409","412","425","426","427","428","429","430","431","435","447","448","450","451","452","454","455","456","457","458","460","465","466","467","468","469","481","485","490","491","492","493","520","530","550","575","580","610","621","622","623","624","630","631","632","633","635","640","650","655","700","701","702","703","704","705","706","707","708","709","710","711","712","713","714","715","716","720","722","723","724","730","740","741","743","744","745","746","750","760","761","763","764","765","766","770","775","780","781","782","783","784","785","786","787","788","789","790","791","792","793","794","795","796","797","798","799","810","811","812","820","821","822","823","824","825","830","833","840","841","850","851","852","853","855","856","860","861","862","863","864","865","870","890","895","896","901","910","911","913","914","915","916","917","925","926","927","929","930","931","932","933","934","935","936","937","938","940","941","950","951","952","953","954","955","960","961","962","963","964","965","966","990","991","995","996","998" }; }
    static StructureItem mFieldF1001 = null;
    static StructureItem getFieldF1001() { initCodeListF1001(); if (mFieldF1001 == null) initFieldF1001(); return mFieldF1001; }
    static void initFieldF1001 ()  { mFieldF1001 = new DataElement ("F1001",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true,  mCodeListF1001))  ); }

    static StructureItem mFieldF1004 = null;
    static StructureItem getFieldF1004() {  if (mFieldF1004 == null) initFieldF1004(); return mFieldF1004; }
    static void initFieldF1004 ()  { mFieldF1004 = new DataElement ("F1004",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF1056 = null;
    static StructureItem getFieldF1056() {  if (mFieldF1056 == null) initFieldF1056(); return mFieldF1056; }
    static void initFieldF1056 ()  { mFieldF1056 = new DataElement ("F1056",
            new  DataTypeValidatorString(0, 9,  null  )  ); }

    static StructureItem mFieldF1060 = null;
    static StructureItem getFieldF1060() {  if (mFieldF1060 == null) initFieldF1060(); return mFieldF1060; }
    static void initFieldF1060 ()  { mFieldF1060 = new DataElement ("F1060",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static String[] mCodeListF1131 = null;
    static void initCodeListF1131 () { mCodeListF1131 =
            new String[] { "12","16","23","25","33","34","35","36","37","38","39","40","42","43","44","45","46","47","48","49","52","53","54","55","56","57","58","59","60","61","62","63","64","65","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","100","101","102","103","104","105","106","107","108","109","110","112","113","114","115","116","117","118","119","120","121","122","123","125","126","127","128","129","130","131","132","133","134","135","136","137","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","160","161","162","163","164","165","166","167","168","169","170","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","220","221","222","223","224","225","226","227","228","229","230","231","232","233","234","235","236","237","238","239","240","241","242","243","244","245","246","247","248","249","250","251","252","253","254","255","256","257","258","259","260","261","262","263","264","265","266","267","268","269","270","271","272","273","ZZZ" }; }
    static StructureItem mFieldF1131 = null;
    static StructureItem getFieldF1131() { initCodeListF1131(); if (mFieldF1131 == null) initFieldF1131(); return mFieldF1131; }
    static void initFieldF1131 ()  { mFieldF1131 = new DataElement ("F1131",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1131    ))  ); }

    static String[] mCodeListF1153 = null;
    static void initCodeListF1153 () { mCodeListF1153 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAG","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAS","AAT","AAU","AAV","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ABO","ABP","ABQ","ABR","ABS","ABT","ABU","ABV","ABW","ABX","ABY","ABZ","AC","ACA","ACB","ACC","ACD","ACE","ACF","ACG","ACH","ACI","ACJ","ACK","ACL","ACM","ACN","ACO","ACP","ACQ","ACR","ACS","ACT","ACU","ACV","ACW","ACX","ACY","ACZ","ADA","ADB","ADC","ADD","ADE","ADF","ADG","ADH","ADI","ADJ","ADK","ADL","ADM","ADN","ADO","ADP","ADQ","ADR","ADS","ADT","ADU","ADV","ADW","ADY","ADZ","AE","AEA","AEB","AEC","AED","AEE","AEF","AEG","AEH","AEI","AEJ","AEK","AEL","AEM","AEN","AEO","AEP","AEQ","AER","AES","AET","AEU","AEV","AEW","AEX","AEY","AEZ","AF","AFA","AFB","AFC","AFD","AFE","AFF","AFG","AFH","AFI","AFJ","AFK","AFL","AFM","AFN","AFO","AFP","AFQ","AFR","AFS","AFT","AFU","AFV","AFW","AFX","AFY","AFZ","AGA","AGB","AGC","AGD","AGE","AGF","AGG","AGH","AGI","AGJ","AGK","AGL","AGM","AGN","AGO","AGP","AGQ","AGR","AGS","AGT","AGU","AGV","AGW","AGX","AGY","AGZ","AHA","AHB","AHC","AHD","AHE","AHF","AHG","AHH","AHI","AHJ","AHK","AHL","AHM","AHN","AHO","AHP","AHQ","AHR","AHS","AHT","AHU","AHV","AHW","AHX","AHY","AHZ","AIA","AIB","AIC","AID","AIE","AIF","AIG","AIH","AII","AIJ","AIK","AIL","AIM","AIN","AIO","AIP","AIQ","AIR","AIS","AIT","AIU","AIV","AIW","AIX","AIY","AIZ","AJA","AJB","AJC","AJD","AJE","AJF","AJG","AJH","AJI","AJJ","AJK","AJL","AJM","AJN","AJO","AJP","AJQ","AJR","AJS","AJT","AJU","AJV","AJW","AJX","AJY","AJZ","AKA","AKB","AKC","AKD","AKE","AKF","AKG","AKH","AKI","AKJ","AKK","AKL","AKM","AKN","AKO","AKP","AKQ","AKR","AKS","AKT","AKU","AKV","AKW","AKX","AKY","AKZ","ALA","ALB","ALC","ALD","ALE","ALF","ALG","ALH","ALI","ALJ","ALK","ALL","ALM","ALN","ALO","ALP","ALQ","ALR","ALS","ALT","ALU","ALV","ALW","ALX","ALY","ALZ","AMA","AMB","AMC","AMD","AME","AMF","AMG","AMH","AMI","AMJ","AMK","AML","AMM","AMN","AMO","AMP","AMQ","AMR","AMS","AMT","AMU","AMV","AMW","AMX","AMY","AMZ","ANA","ANB","ANC","AND","ANE","ANF","ANG","ANH","ANI","ANJ","ANK","ANM","ANN","ANO","ANP","ANQ","ANR","ANS","ANT","ANU","ANV","ANW","ANX","ANY","ANZ","AOA","AOB","AOC","AOD","AOE","AOF","AOG","AOH","AOI","AOJ","AOK","AOL","AOM","AON","AOO","AOP","AOQ","AOR","AOS","AOT","AOU","AOV","AOW","AOX","AOY","AOZ","AP","APA","APB","APC","APD","APE","APF","APG","APH","API","APJ","APK","APM","APN","APO","APP","APQ","APR","APT","APU","APV","APW","APX","APY","APZ","AQA","AQB","AQC","AQD","AQE","AQF","AQG","AQH","AQI","AQJ","AQK","AQL","AQM","AQN","AQO","AQP","AQQ","AQR","AQS","AQT","AQU","AQV","AQW","AQX","AQY","AQZ","ARA","ARB","ARC","ARD","ARE","ARF","ARG","ARH","ARI","ARJ","ARK","ARL","ARM","ARN","ARO","ARP","ARQ","ARR","ARS","ART","ARU","ARV","ARW","ARX","ASA","ASB","ASC","ASD","ASE","ASF","ASG","ASH","ASI","ASJ","ASK","ASL","ASM","ASN","AU","AV","AWA","AWB","AWC","AWD","AWE","AWF","AWG","AWH","AWI","BA","BC","BD","BE","BH","BM","BN","BO","BR","BT","BW","CAS","CD","CEC","CFE","CFO","CG","CH","CK","CKN","CM","CMR","CN","CNO","CO","COF","CP","CR","CRN","CS","CST","CT","CU","CV","CW","CZ","DA","DAN","DB","DI","DL","DM","DQ","DR","EA","EB","ED","EE","EI","EN","EP","EQ","ER","ERN","ET","EX","FC","FF","FI","FLW","FN","FO","FS","FT","FV","FX","GA","GC","GD","GDN","GN","HS","HWB","IA","IB","ICA","ICE","ICO","II","IL","INB","INN","INO","IP","IS","IT","IV","JB","JE","LA","LAN","LAR","LB","LC","LI","LO","LS","MA","MB","MF","MG","MH","MR","MRN","MS","MSS","MWB","NA","OH","OI","ON","OP","OR","PB","PC","PD","PE","PF","PI","PK","PL","POR","PP","PQ","PR","PS","PW","PY","RA","RC","RCN","RE","REN","RF","RR","RT","SA","SB","SD","SE","SF","SH","SI","SM","SN","SP","SQ","SRN","SS","STA","SW","SZ","TB","TE","TF","TI","TL","TN","TP","UAR","UC","UCN","UN","UO","VA","VC","VM","VN","VON","VP","VR","VS","VT","VV","WE","WM","WN","WR","WS","WY","XA","XC","XP","ZZZ" }; }
    static StructureItem mFieldF1153 = null;
    static StructureItem getFieldF1153() { initCodeListF1153(); if (mFieldF1153 == null) initFieldF1153(); return mFieldF1153; }
    static void initFieldF1153 ()  { mFieldF1153 = new DataElement ("F1153",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1153    ))  ); }

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

    static String[] mCodeListF1225 = null;
    static void initCodeListF1225 () { mCodeListF1225 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60" }; }
    static StructureItem mFieldF1225 = null;
    static StructureItem getFieldF1225() { initCodeListF1225(); if (mFieldF1225 == null) initFieldF1225(); return mFieldF1225; }
    static void initFieldF1225 ()  { mFieldF1225 = new DataElement ("F1225",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1225    ))  ); }

    static StructureItem mFieldF1366 = null;
    static StructureItem getFieldF1366() {  if (mFieldF1366 == null) initFieldF1366(); return mFieldF1366; }
    static void initFieldF1366 ()  { mFieldF1366 = new DataElement ("F1366",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static String[] mCodeListF1373 = null;
    static void initCodeListF1373 () { mCodeListF1373 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31" }; }
    static StructureItem mFieldF1373 = null;
    static StructureItem getFieldF1373() { initCodeListF1373(); if (mFieldF1373 == null) initFieldF1373(); return mFieldF1373; }
    static void initFieldF1373 ()  { mFieldF1373 = new DataElement ("F1373",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF1373    ))  ); }

    static StructureItem mFieldF1496 = null;
    static StructureItem getFieldF1496() {  if (mFieldF1496 == null) initFieldF1496(); return mFieldF1496; }
    static void initFieldF1496 ()  { mFieldF1496 = new DataElement ("F1496",
            new  DataTypeValidatorDecimal(0, 5, 0)  ); }

    static String[] mCodeListF2005 = null;
    static void initCodeListF2005 () { mCodeListF2005 =
            new String[] { "2","3","4","7","8","9","10","11","12","13","14","15","16","17","18","20","21","22","35","36","37","38","39","42","44","45","46","47","48","49","50","51","52","53","54","55","58","59","60","61","63","64","65","67","69","71","72","74","75","76","79","81","84","85","89","90","91","92","93","94","95","96","97","101","107","108","109","110","111","113","114","115","116","117","118","119","123","124","125","126","128","129","131","132","133","134","135","136","137","138","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","221","222","223","224","225","226","227","228","229","230","231","232","233","234","235","236","237","238","239","240","241","242","243","244","245","246","247","248","249","250","251","252","253","254","255","256","257","258","259","260","261","262","263","264","265","266","267","268","270","271","272","273","274","275","276","277","278","279","280","281","282","283","284","285","286","287","288","290","291","292","293","294","295","296","297","298","299","300","301","302","303","304","305","306","307","308","309","310","311","312","313","314","315","316","317","318","319","320","321","322","323","324","325","326","327","328","329","330","331","332","333","334","335","336","337","338","339","340","341","342","343","344","345","346","347","348","349","350","351","352","353","354","355","356","357","358","359","360","361","362","363","364","365","366","367","368","369","370","371","372","373","374","375","376","377","378","379","380","381","382","383","384","387","388","389","390","391","392","393","394","395","396","397","398","399","400","401","402","403","404","405","406","407","408","409","410","411","412","413","414","415","416","417","418","419","420","421","422","423","424","425","426","427","428","429","430","431","432","433","434","435","436","437","438","439","440","441","442","443","444","445","446","447","448","449","450","451","452","453","454","455","456","457","458","459","460","461","462","463","464","465","466","467","468","469","470","471","472","473","474","475","476","477","478","479","480","481","482","483","484","485","486","487","488","489","490","491","493","494","495","496","497","498","499","500","501","502","503","504","505","506","507","508","509","510","511","512","513","514","515","516","517","518","519","520","521","522","523","524","525","526","527","528","529","530","531","532","533","534","535","536","537","538","539","541","542","543","544","545","546","547","548","549","550","551","552","553","554","555","556","557","558","559","560","561","562","563","564","565","566","567","568","569","570","571","572","573","574","575","576","577","578","579","580","581","582","583","584","585","586","587","588","589","590","591","592","593","594","596","597","598","599","600","601","602","603","604","605","606","607","608","609","610","611","612","613","614","615","616","617","618","619","620","621","622","623","624","625","626","627","628","629","630","631","632","633","634","635","636","637","638","639","640","641","642","643","644","645","646","647","648","649","651","652","653","654","655","656","657","658","659","660","661","662","663","664","665","666","667","668","669","670","671","672","673","674","675","676","677","678","679","680","681","682","683","684","685","686","687","688","689","690","ZZZ" }; }
    static StructureItem mFieldF2005 = null;
    static StructureItem getFieldF2005() { initCodeListF2005(); if (mFieldF2005 == null) initFieldF2005(); return mFieldF2005; }
    static void initFieldF2005 ()  { mFieldF2005 = new DataElement ("F2005",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF2005    ))  ); }

    static String[] mCodeListF2379 = null;
    static void initCodeListF2379 () { mCodeListF2379 =
            new String[] { "2","3","101","102","103","105","106","107","108","109","110","201","202","203","204","301","302","303","304","305","306","401","402","404","405","501","502","503","600","601","602","603","604","608","609","610","613","614","615","616","701","702","703","704","705","706","707","708","709","710","711","713","715","716","717","718","719","801","802","803","804","805","806","807","808","809","810","811","812","813","814" }; }
    static StructureItem mFieldF2379 = null;
    static StructureItem getFieldF2379() { initCodeListF2379(); if (mFieldF2379 == null) initFieldF2379(); return mFieldF2379; }
    static void initFieldF2379 ()  { mFieldF2379 = new DataElement ("F2379",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF2379    ))  ); }

    static StructureItem mFieldF2380 = null;
    static StructureItem getFieldF2380() {  if (mFieldF2380 == null) initFieldF2380(); return mFieldF2380; }
    static void initFieldF2380 ()  { mFieldF2380 = new DataElement ("F2380",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF3035 = null;
    static void initCodeListF3035 () { mCodeListF3035 =
            new String[] { "AA","AB","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","AZ","B1","B2","BA","BB","BC","BD","BE","BF","BG","BH","BI","BJ","BK","BL","BM","BN","BO","BP","BQ","BS","BT","BU","BV","BW","BX","BY","BZ","C1","C2","CA","CB","CC","CD","CE","CF","CG","CH","CI","CJ","CK","CL","CM","CN","CO","COP","COQ","CP","CPA","CPB","CPC","CPD","CPE","CPF","CQ","CR","CS","CT","CU","CV","CW","CX","CY","CZ","DA","DB","DC","DCP","DD","DE","DF","DG","DH","DI","DJ","DK","DL","DM","DN","DO","DP","DQ","DR","DS","DT","DU","DV","DW","DX","DY","DZ","EA","EB","EC","ED","EE","EF","EG","EH","EI","EJ","EK","EL","EM","EN","EO","EP","EQ","ER","ES","ET","EU","EV","EW","EX","EY","EZ","FA","FB","FC","FD","FE","FF","FG","FH","FI","FJ","FK","FL","FM","FN","FO","FP","FQ","FR","FS","FT","FU","FV","FW","FX","FY","FZ","GA","GB","GC","GD","GE","GF","GG","GH","GI","GJ","GK","GL","GM","GN","GO","GP","GQ","GR","GS","GT","GU","GV","GW","GX","GY","GZ","HA","HB","HC","HD","HE","HF","HG","HH","HI","HJ","HK","HL","HM","HN","HO","HP","HQ","HR","HS","HT","HU","HV","HW","HX","HY","HZ","I1","I2","IB","IC","ID","IE","IF","IG","IH","II","IJ","IL","IM","IN","IO","IP","IQ","IR","IS","IT","IU","IV","IW","IX","IY","IZ","LA","LB","LC","LD","LE","LF","LG","LH","LI","LJ","LK","LL","LM","LN","LO","LP","LQ","LR","LS","LT","LU","LV","MA","MF","MG","MI","MP","MR","MS","MT","N1","N2","NI","OA","OB","OC","OD","OE","OF","OG","OH","OI","OJ","OK","OL","OM","ON","OO","OP","OQ","OR","OS","OT","OU","OV","OW","OX","OY","OZ","P1","P2","P3","P4","PA","PB","PC","PD","PE","PF","PG","PH","PI","PJ","PK","PL","PM","PN","PO","PQ","PR","PS","PT","PW","PX","PY","PZ","RA","RB","RE","RF","RH","RI","RL","RM","RP","RS","RV","RW","SB","SE","SF","SG","SI","SK","SN","SO","SR","SS","ST","SU","SX","SY","SZ","TA","TB","TC","TCP","TD","TE","TF","TG","TH","TI","TJ","TK","TL","TM","TN","TO","TP","TQ","TR","TS","TT","TU","TV","TW","TX","TY","TZ","UA","UB","UC","UD","UE","UF","UG","UH","UHP","UI","UJ","UK","UL","UM","UN","UO","UP","UQ","UR","US","UT","UU","UV","UW","UX","UY","UZ","VA","VB","VC","VE","VF","VG","VH","VI","VJ","VK","VL","VM","VN","VO","VP","VQ","VR","VS","VT","VU","VV","VW","VX","VY","VZ","WA","WB","WC","WD","WE","WF","WG","WH","WI","WJ","WK","WL","WM","WN","WO","WP","WPA","WQ","WR","WS","WT","WU","WV","WW","XX","ZZZ" }; }
    static StructureItem mFieldF3035 = null;
    static StructureItem getFieldF3035() { initCodeListF3035(); if (mFieldF3035 == null) initFieldF3035(); return mFieldF3035; }
    static void initFieldF3035 ()  { mFieldF3035 = new DataElement ("F3035",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3035    ))  ); }

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
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3045    ))  ); }

    static String[] mCodeListF3055 = null;
    static void initCodeListF3055 () { mCodeListF3055 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","220","221","222","223","224","225","226","227","228","229","230","231","233","234","235","236","237","238","239","ZZZ" }; }
    static StructureItem mFieldF3055 = null;
    static StructureItem getFieldF3055() { initCodeListF3055(); if (mFieldF3055 == null) initFieldF3055(); return mFieldF3055; }
    static void initFieldF3055 ()  { mFieldF3055 = new DataElement ("F3055",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3055    ))  ); }

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
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","AZ","BA","BB","BC","BD","BE","BF","BG","BH","BI","BJ","BK","BL","BM","BN","BU","CA","CB","CC","CD","CE","CF","CG","CN","CO","CP","CR","CW","DE","DI","DL","EB","EC","ED","EX","GR","HE","HG","HM","IC","IN","LB","LO","MC","MD","MH","MR","MS","NT","OC","PA","PD","PE","PM","QA","QC","RD","SA","SC","SD","SR","SU","TA","TD","TI","TR","WH","ZZZ" }; }
    static StructureItem mFieldF3139 = null;
    static StructureItem getFieldF3139() { initCodeListF3139(); if (mFieldF3139 == null) initFieldF3139(); return mFieldF3139; }
    static void initFieldF3139 ()  { mFieldF3139 = new DataElement ("F3139",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3139    ))  ); }

    static StructureItem mFieldF3148 = null;
    static StructureItem getFieldF3148() {  if (mFieldF3148 == null) initFieldF3148(); return mFieldF3148; }
    static void initFieldF3148 ()  { mFieldF3148 = new DataElement ("F3148",
            new  DataTypeValidatorString(0, 512,  null  )  ); }

    static String[] mCodeListF3153 = null;
    static void initCodeListF3153 () { mCodeListF3153 =
            new String[] { "AA","AB","AC","AD","CA","EI","EM","EX","FT","FX","GM","IE","IM","MA","PB","PS","SW","TE","TG","TL","TM","TT","TX","XF" }; }
    static StructureItem mFieldF3153 = null;
    static StructureItem getFieldF3153() { initCodeListF3153(); if (mFieldF3153 == null) initFieldF3153(); return mFieldF3153; }
    static void initFieldF3153 ()  { mFieldF3153 = new DataElement ("F3153",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3153    ))  ); }

    static String[] mCodeListF3155 = null;
    static void initCodeListF3155 () { mCodeListF3155 =
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","CA","EI","EM","EX","FT","FX","GM","IE","IM","MA","PB","PS","SW","TE","TG","TL","TM","TT","TX","XF" }; }
    static StructureItem mFieldF3155 = null;
    static StructureItem getFieldF3155() { initCodeListF3155(); if (mFieldF3155 == null) initFieldF3155(); return mFieldF3155; }
    static void initFieldF3155 ()  { mFieldF3155 = new DataElement ("F3155",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3155    ))  ); }

    static StructureItem mFieldF3164 = null;
    static StructureItem getFieldF3164() {  if (mFieldF3164 == null) initFieldF3164(); return mFieldF3164; }
    static void initFieldF3164 ()  { mFieldF3164 = new DataElement ("F3164",
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
            new String[] { "1","2","4","5","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","ZZZ" }; }
    static StructureItem mFieldF3227 = null;
    static StructureItem getFieldF3227() { initCodeListF3227(); if (mFieldF3227 == null) initFieldF3227(); return mFieldF3227; }
    static void initFieldF3227 ()  { mFieldF3227 = new DataElement ("F3227",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF3227    ))  ); }

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

    static StructureItem mFieldF3251 = null;
    static StructureItem getFieldF3251() {  if (mFieldF3251 == null) initFieldF3251(); return mFieldF3251; }
    static void initFieldF3251 ()  { mFieldF3251 = new DataElement ("F3251",
            new  DataTypeValidatorString(0, 9,  null  )  ); }

    static StructureItem mFieldF3412 = null;
    static StructureItem getFieldF3412() {  if (mFieldF3412 == null) initFieldF3412(); return mFieldF3412; }
    static void initFieldF3412 ()  { mFieldF3412 = new DataElement ("F3412",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF3413 = null;
    static StructureItem getFieldF3413() {  if (mFieldF3413 == null) initFieldF3413(); return mFieldF3413; }
    static void initFieldF3413 ()  { mFieldF3413 = new DataElement ("F3413",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF3453 = null;
    static StructureItem getFieldF3453() {  if (mFieldF3453 == null) initFieldF3453(); return mFieldF3453; }
    static void initFieldF3453 ()  { mFieldF3453 = new DataElement ("F3453",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF4000 = null;
    static StructureItem getFieldF4000() {  if (mFieldF4000 == null) initFieldF4000(); return mFieldF4000; }
    static void initFieldF4000 ()  { mFieldF4000 = new DataElement ("F4000",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF4052 = null;
    static StructureItem getFieldF4052() {  if (mFieldF4052 == null) initFieldF4052(); return mFieldF4052; }
    static void initFieldF4052 ()  { mFieldF4052 = new DataElement ("F4052",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static String[] mCodeListF4053 = null;
    static void initCodeListF4053 () { mCodeListF4053 =
            new String[] { "1" }; }
    static StructureItem mFieldF4053 = null;
    static StructureItem getFieldF4053() { initCodeListF4053(); if (mFieldF4053 == null) initFieldF4053(); return mFieldF4053; }
    static void initFieldF4053 ()  { mFieldF4053 = new DataElement ("F4053",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4053    ))  ); }

    static String[] mCodeListF4055 = null;
    static void initCodeListF4055 () { mCodeListF4055 =
            new String[] { "1","2","3","4","5","6" }; }
    static StructureItem mFieldF4055 = null;
    static StructureItem getFieldF4055() { initCodeListF4055(); if (mFieldF4055 == null) initFieldF4055(); return mFieldF4055; }
    static void initFieldF4055 ()  { mFieldF4055 = new DataElement ("F4055",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4055    ))  ); }

    static String[] mCodeListF4065 = null;
    static void initCodeListF4065 () { mCodeListF4065 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36" }; }
    static StructureItem mFieldF4065 = null;
    static StructureItem getFieldF4065() { initCodeListF4065(); if (mFieldF4065 == null) initFieldF4065(); return mFieldF4065; }
    static void initFieldF4065 ()  { mFieldF4065 = new DataElement ("F4065",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4065    ))  ); }

    static StructureItem mFieldF4078 = null;
    static StructureItem getFieldF4078() {  if (mFieldF4078 == null) initFieldF4078(); return mFieldF4078; }
    static void initFieldF4078 ()  { mFieldF4078 = new DataElement ("F4078",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF4079 = null;
    static StructureItem getFieldF4079() {  if (mFieldF4079 == null) initFieldF4079(); return mFieldF4079; }
    static void initFieldF4079 ()  { mFieldF4079 = new DataElement ("F4079",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static String[] mCodeListF4215 = null;
    static void initCodeListF4215 () { mCodeListF4215 =
            new String[] { "A","AA","AB","AC","AD","CA","CC","CF","DF","FO","IC","MX","NC","NS","PA","PB","PC","PE","PO","PP","PU","RC","RF","RS","TP","WC","ZZZ" }; }
    static StructureItem mFieldF4215 = null;
    static StructureItem getFieldF4215() { initCodeListF4215(); if (mFieldF4215 == null) initFieldF4215(); return mFieldF4215; }
    static void initFieldF4215 ()  { mFieldF4215 = new DataElement ("F4215",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4215    ))  ); }

    static String[] mCodeListF4219 = null;
    static void initCodeListF4219 () { mCodeListF4219 =
            new String[] { "1","2","3","4" }; }
    static StructureItem mFieldF4219 = null;
    static StructureItem getFieldF4219() { initCodeListF4219(); if (mFieldF4219 == null) initFieldF4219(); return mFieldF4219; }
    static void initFieldF4219 ()  { mFieldF4219 = new DataElement ("F4219",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4219    ))  ); }

    static String[] mCodeListF4233 = null;
    static void initCodeListF4233 () { mCodeListF4233 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","ZZZ" }; }
    static StructureItem mFieldF4233 = null;
    static StructureItem getFieldF4233() { initCodeListF4233(); if (mFieldF4233 == null) initFieldF4233(); return mFieldF4233; }
    static void initFieldF4233 ()  { mFieldF4233 = new DataElement ("F4233",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4233    ))  ); }

    static String[] mCodeListF4237 = null;
    static void initCodeListF4237 () { mCodeListF4237 =
            new String[] { "A","B","C","P" }; }
    static StructureItem mFieldF4237 = null;
    static StructureItem getFieldF4237() { initCodeListF4237(); if (mFieldF4237 == null) initFieldF4237(); return mFieldF4237; }
    static void initFieldF4237 ()  { mFieldF4237 = new DataElement ("F4237",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4237    ))  ); }

    static String[] mCodeListF4343 = null;
    static void initCodeListF4343 () { mCodeListF4343 =
            new String[] { "AA","AB","AC","AD","AF","AG","AI","AJ","AP","AQ","AR","AS","CA","CO","NA","RE" }; }
    static StructureItem mFieldF4343 = null;
    static StructureItem getFieldF4343() { initCodeListF4343(); if (mFieldF4343 == null) initFieldF4343(); return mFieldF4343; }
    static void initFieldF4343 ()  { mFieldF4343 = new DataElement ("F4343",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4343    ))  ); }

    static String[] mCodeListF4347 = null;
    static void initCodeListF4347 () { mCodeListF4347 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12" }; }
    static StructureItem mFieldF4347 = null;
    static StructureItem getFieldF4347() { initCodeListF4347(); if (mFieldF4347 == null) initFieldF4347(); return mFieldF4347; }
    static void initFieldF4347 ()  { mFieldF4347 = new DataElement ("F4347",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4347    ))  ); }

    static String[] mCodeListF4405 = null;
    static void initCodeListF4405 () { mCodeListF4405 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","57","58","59","60","63","64","71","72","74","76","77","78","79","80","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105" }; }
    static StructureItem mFieldF4405 = null;
    static StructureItem getFieldF4405() { initCodeListF4405(); if (mFieldF4405 == null) initFieldF4405(); return mFieldF4405; }
    static void initFieldF4405 ()  { mFieldF4405 = new DataElement ("F4405",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4405    ))  ); }

    static StructureItem mFieldF4440 = null;
    static StructureItem getFieldF4440() {  if (mFieldF4440 == null) initFieldF4440(); return mFieldF4440; }
    static void initFieldF4440 ()  { mFieldF4440 = new DataElement ("F4440",
            new  DataTypeValidatorString(0, 70,  null  )  ); }

    static StructureItem mFieldF4441 = null;
    static StructureItem getFieldF4441() {  if (mFieldF4441 == null) initFieldF4441(); return mFieldF4441; }
    static void initFieldF4441 ()  { mFieldF4441 = new DataElement ("F4441",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF4447 = null;
    static void initCodeListF4447 () { mCodeListF4447 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11" }; }
    static StructureItem mFieldF4447 = null;
    static StructureItem getFieldF4447() { initCodeListF4447(); if (mFieldF4447 == null) initFieldF4447(); return mFieldF4447; }
    static void initFieldF4447 ()  { mFieldF4447 = new DataElement ("F4447",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4447    ))  ); }

    static String[] mCodeListF4451 = null;
    static void initCodeListF4451 () { mCodeListF4451 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ABO","ABP","ABQ","ABR","ABS","ABT","ABU","ABV","ABW","ABX","ABY","ABZ","ACA","ACB","ACC","ACD","ACE","ACF","ACG","ACH","ACI","ACJ","ACK","ACL","ACM","ACN","ACO","ACP","ACQ","ACR","ACS","ACT","ACU","ACV","ACW","ACX","ACY","ACZ","ADA","ADB","ADC","ADD","ADE","ADF","ADG","ADH","ADI","ADJ","ADK","ADL","ADM","ADN","ADO","ADP","ADQ","ADR","ADS","ADT","ADU","ADV","ADW","ADX","ADY","ADZ","AEA","AEB","AEC","AED","AEE","AEF","AEG","AEH","AEI","AEJ","AEK","AEL","AEM","AEN","AEO","AEP","AEQ","AER","AES","AET","AEU","AEV","AEW","AEX","AEY","AEZ","AFA","AFB","AFC","AFD","AFE","AFF","AFG","AFH","AFI","AFJ","AFK","AFL","AFM","AFN","AFO","AFP","AFQ","AFR","AFS","AFT","AFU","AFV","AFW","AFX","AFY","AFZ","AGA","AGB","AGC","AGD","AGE","AGF","AGG","AGH","AGI","AGJ","AGK","AGL","AGM","AGN","AGO","AGP","AGQ","AGR","AGS","AGT","AGU","AGV","AGW","AGX","AGY","AGZ","AHA","AHB","AHC","AHD","AHE","AHF","AHG","AHH","AHI","AHJ","AHK","AHL","AHM","AHN","AHO","AHP","AHQ","AHR","AHS","AHT","AHU","AHV","AHW","AHX","AHY","AHZ","AIA","AIB","AIC","AID","AIE","ALC","ALL","ARR","AUT","BLC","BLR","CCI","CEX","CHG","CIP","CLP","CLR","COI","CUR","CUS","DAR","DCL","DEL","DIN","DOC","DUT","EUR","FBC","GBL","GEN","GS7","HAN","HAZ","ICN","IIN","IMI","IND","INS","INV","IRP","ITR","ITS","LIN","LOI","MCO","MKS","ORI","OSI","PAC","PAI","PAY","PKG","PKT","PMD","PMT","PRD","PRF","PRI","PUR","QIN","QQD","QUT","RAH","REG","RET","REV","RQR","RQT","SAF","SIC","SIN","SLR","SPA","SPG","SPH","SPP","SPT","SRN","SSR","SUR","TCA","TDT","TRA","TRR","TXD","WHI","ZZZ" }; }
    static StructureItem mFieldF4451 = null;
    static StructureItem getFieldF4451() { initCodeListF4451(); if (mFieldF4451 == null) initFieldF4451(); return mFieldF4451; }
    static void initFieldF4451 ()  { mFieldF4451 = new DataElement ("F4451",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4451    ))  ); }

    static String[] mCodeListF4453 = null;
    static void initCodeListF4453 () { mCodeListF4453 =
            new String[] { "1","2","3","4","5","6","7" }; }
    static StructureItem mFieldF4453 = null;
    static StructureItem getFieldF4453() { initCodeListF4453(); if (mFieldF4453 == null) initFieldF4453(); return mFieldF4453; }
    static void initFieldF4453 ()  { mFieldF4453 = new DataElement ("F4453",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4453    ))  ); }

    static String[] mCodeListF4517 = null;
    static void initCodeListF4517 () { mCodeListF4517 =
            new String[] { "1","2","3" }; }
    static StructureItem mFieldF4517 = null;
    static StructureItem getFieldF4517() { initCodeListF4517(); if (mFieldF4517 == null) initFieldF4517(); return mFieldF4517; }
    static void initFieldF4517 ()  { mFieldF4517 = new DataElement ("F4517",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF4517    ))  ); }

    static StructureItem mFieldF5004 = null;
    static StructureItem getFieldF5004() {  if (mFieldF5004 == null) initFieldF5004(); return mFieldF5004; }
    static void initFieldF5004 ()  { mFieldF5004 = new DataElement ("F5004",
            new  DataTypeValidatorDecimal(0, 35, 0)  ); }

    static String[] mCodeListF5025 = null;
    static void initCodeListF5025 () { mCodeListF5025 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","220","221","222","223","224","225","226","227","228","229","230","231","232","233","234","235","236","237","238","239","240","241","242","243","244","245","246","247","248","249","250","251","252","253","254","255","256","257","258","259","260","261","262","263","264","265","266","267","268","269","270","271","272","273","274","275","276","277","278","279","280","281","282","283","284","285","286","287","288","289","290","291","292","293","294","295","296","297","298","299","300","301","302","303","304","305","306","307","308","309","310","311","312","313","314","315","316","317","318","319","320","321","322","323","324","325","326","327","328","329","330","331","332","333","334","335","336","337","338","339","340","341","342","343","344","345","346","347","348","349","350","351","352","353","354","355","356","357","358","359","360","361","362","363","364","365","366","367","368","369","370","371","372","373","374","375","376","377","378","379","380","381","382","383","384","385","386","387","388","389","390","391","392","393","394","395","396","397","398","399","400","401","402","403","404","405","406","407","ZZZ" }; }
    static StructureItem mFieldF5025 = null;
    static StructureItem getFieldF5025() { initCodeListF5025(); if (mFieldF5025 == null) initFieldF5025(); return mFieldF5025; }
    static void initFieldF5025 ()  { mFieldF5025 = new DataElement ("F5025",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5025    ))  ); }

    static StructureItem mFieldF5118 = null;
    static StructureItem getFieldF5118() {  if (mFieldF5118 == null) initFieldF5118(); return mFieldF5118; }
    static void initFieldF5118 ()  { mFieldF5118 = new DataElement ("F5118",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static String[] mCodeListF5125 = null;
    static void initCodeListF5125 () { mCodeListF5125 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAF","AAG","CAL","INF","INV" }; }
    static StructureItem mFieldF5125 = null;
    static StructureItem getFieldF5125() { initCodeListF5125(); if (mFieldF5125 == null) initFieldF5125(); return mFieldF5125; }
    static void initFieldF5125 ()  { mFieldF5125 = new DataElement ("F5125",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5125    ))  ); }

    static String[] mCodeListF5213 = null;
    static void initCodeListF5213 () { mCodeListF5213 =
            new String[] { "A","I","S" }; }
    static StructureItem mFieldF5213 = null;
    static StructureItem getFieldF5213() { initCodeListF5213(); if (mFieldF5213 == null) initFieldF5213(); return mFieldF5213; }
    static void initFieldF5213 ()  { mFieldF5213 = new DataElement ("F5213",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5213    ))  ); }

    static String[] mCodeListF5237 = null;
    static void initCodeListF5237 () { mCodeListF5237 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18" }; }
    static StructureItem mFieldF5237 = null;
    static StructureItem getFieldF5237() { initCodeListF5237(); if (mFieldF5237 == null) initFieldF5237(); return mFieldF5237; }
    static void initFieldF5237 ()  { mFieldF5237 = new DataElement ("F5237",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5237    ))  ); }

    static StructureItem mFieldF5242 = null;
    static StructureItem getFieldF5242() {  if (mFieldF5242 == null) initFieldF5242(); return mFieldF5242; }
    static void initFieldF5242 ()  { mFieldF5242 = new DataElement ("F5242",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF5243 = null;
    static void initCodeListF5243 () { mCodeListF5243 =
            new String[] { "A","B","C","D","E","F","K","M","N","Q","R","S" }; }
    static StructureItem mFieldF5243 = null;
    static StructureItem getFieldF5243() { initCodeListF5243(); if (mFieldF5243 == null) initFieldF5243(); return mFieldF5243; }
    static void initFieldF5243 ()  { mFieldF5243 = new DataElement ("F5243",
            new  DataTypeValidatorString(0, 9,  new DataValueCodeListValidator(true, mCodeListF5243    ))  ); }

    static String[] mCodeListF5245 = null;
    static void initCodeListF5245 () { mCodeListF5245 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127","128" }; }
    static StructureItem mFieldF5245 = null;
    static StructureItem getFieldF5245() { initCodeListF5245(); if (mFieldF5245 == null) initFieldF5245(); return mFieldF5245; }
    static void initFieldF5245 ()  { mFieldF5245 = new DataElement ("F5245",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5245    ))  ); }

    static String[] mCodeListF5249 = null;
    static void initCodeListF5249 () { mCodeListF5249 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16" }; }
    static StructureItem mFieldF5249 = null;
    static StructureItem getFieldF5249() { initCodeListF5249(); if (mFieldF5249 == null) initFieldF5249(); return mFieldF5249; }
    static void initFieldF5249 ()  { mFieldF5249 = new DataElement ("F5249",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5249    ))  ); }

    static StructureItem mFieldF5275 = null;
    static StructureItem getFieldF5275() {  if (mFieldF5275 == null) initFieldF5275(); return mFieldF5275; }
    static void initFieldF5275 ()  { mFieldF5275 = new DataElement ("F5275",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF5284 = null;
    static StructureItem getFieldF5284() {  if (mFieldF5284 == null) initFieldF5284(); return mFieldF5284; }
    static void initFieldF5284 ()  { mFieldF5284 = new DataElement ("F5284",
            new  DataTypeValidatorDecimal(0, 9, 0)  ); }

    static String[] mCodeListF5375 = null;
    static void initCodeListF5375 () { mCodeListF5375 =
            new String[] { "AA","AB","AC","AD","AE","AI","AQ","CA","CT","CU","DI","EC","NW","PC","PE","PK","PL","PT","PU","PV","PW","QT","SR","TB","TU","TW","WH" }; }
    static StructureItem mFieldF5375 = null;
    static StructureItem getFieldF5375() { initCodeListF5375(); if (mFieldF5375 == null) initFieldF5375(); return mFieldF5375; }
    static void initFieldF5375 ()  { mFieldF5375 = new DataElement ("F5375",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5375    ))  ); }

    static String[] mCodeListF5387 = null;
    static void initCodeListF5387 () { mCodeListF5387 =
            new String[] { "AAA","AAB","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ABO","ABP","ABQ","ABR","ABS","ABT","AI","ALT","AP","BR","CAT","CDV","CON","CP","CU","CUP","CUS","DAP","DIS","DPR","DR","DSC","EC","ES","EUP","FCR","GRP","INV","LBL","MAX","MIN","MNR","MSR","MXR","NE","NQT","NTP","NW","OCR","OFR","PAQ","PBQ","PPD","PPR","PRO","PRP","PW","QTE","RES","RTP","SHD","SRP","SW","TB","TRF","TU","TW","WH" }; }
    static StructureItem mFieldF5387 = null;
    static StructureItem getFieldF5387() { initCodeListF5387(); if (mFieldF5387 == null) initFieldF5387(); return mFieldF5387; }
    static void initFieldF5387 ()  { mFieldF5387 = new DataElement ("F5387",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF5387    ))  ); }

    static StructureItem mFieldF5402 = null;
    static StructureItem getFieldF5402() {  if (mFieldF5402 == null) initFieldF5402(); return mFieldF5402; }
    static void initFieldF5402 ()  { mFieldF5402 = new DataElement ("F5402",
            new  DataTypeValidatorDecimal(0, 12, 0)  ); }

    static StructureItem mFieldF5479 = null;
    static StructureItem getFieldF5479() {  if (mFieldF5479 == null) initFieldF5479(); return mFieldF5479; }
    static void initFieldF5479 ()  { mFieldF5479 = new DataElement ("F5479",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF5482 = null;
    static StructureItem getFieldF5482() {  if (mFieldF5482 == null) initFieldF5482(); return mFieldF5482; }
    static void initFieldF5482 ()  { mFieldF5482 = new DataElement ("F5482",
            new  DataTypeValidatorDecimal(0, 10, 0)  ); }

    static StructureItem mFieldF6008 = null;
    static StructureItem getFieldF6008() {  if (mFieldF6008 == null) initFieldF6008(); return mFieldF6008; }
    static void initFieldF6008 ()  { mFieldF6008 = new DataElement ("F6008",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static StructureItem mFieldF6060 = null;
    static StructureItem getFieldF6060() {  if (mFieldF6060 == null) initFieldF6060(); return mFieldF6060; }
    static void initFieldF6060 ()  { mFieldF6060 = new DataElement ("F6060",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static String[] mCodeListF6063 = null;
    static void initCodeListF6063 () { mCodeListF6063 =
            new String[] { "1","2","3","8","11","12","17","18","20","21","22","23","24","25","26","27","28","29","30","31","32","33","35","36","40","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","220","221","222","223","224","225","226","227","228","229","230","231","232","233","234","235","236","237","238","239","240","241","242","243","244","245","246","247","248","249","250","251","252","253","254","255","256","257","258","259","260","261","262","263","264","265","266","267","268","269","270","271","272","273","274","275","276","277","278","279","280","281","282","283","284","285","286","287","288","289","290","291","292","293","294","295","296","297","298","299","300","301","302","303","304","305","306","307","308","309","310","311","312","313","314","315","316","317","318","319","320","321","322","323","324","325","326","327","328","329","330","331","332","333","334","335","336","337","338","339","340","341","342","343","344","345","346","347","348","349","350","351","352","353","354","355","356","357","358","359","360","361","362","363","364","365","366","367" }; }
    static StructureItem mFieldF6063 = null;
    static StructureItem getFieldF6063() { initCodeListF6063(); if (mFieldF6063 == null) initFieldF6063(); return mFieldF6063; }
    static void initFieldF6063 ()  { mFieldF6063 = new DataElement ("F6063",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6063    ))  ); }

    static StructureItem mFieldF6066 = null;
    static StructureItem getFieldF6066() {  if (mFieldF6066 == null) initFieldF6066(); return mFieldF6066; }
    static void initFieldF6066 ()  { mFieldF6066 = new DataElement ("F6066",
            new  DataTypeValidatorDecimal(0, 18, 0)  ); }

    static String[] mCodeListF6069 = null;
    static void initCodeListF6069 () { mCodeListF6069 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51" }; }
    static StructureItem mFieldF6069 = null;
    static StructureItem getFieldF6069() { initCodeListF6069(); if (mFieldF6069 == null) initFieldF6069(); return mFieldF6069; }
    static void initFieldF6069 ()  { mFieldF6069 = new DataElement ("F6069",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6069    ))  ); }

    static StructureItem mFieldF6140 = null;
    static StructureItem getFieldF6140() {  if (mFieldF6140 == null) initFieldF6140(); return mFieldF6140; }
    static void initFieldF6140 ()  { mFieldF6140 = new DataElement ("F6140",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static String[] mCodeListF6145 = null;
    static void initCodeListF6145 () { mCodeListF6145 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14" }; }
    static StructureItem mFieldF6145 = null;
    static StructureItem getFieldF6145() { initCodeListF6145(); if (mFieldF6145 == null) initFieldF6145(); return mFieldF6145; }
    static void initFieldF6145 ()  { mFieldF6145 = new DataElement ("F6145",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6145    ))  ); }

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
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","18","19","20","21","22","23","24","25","26","27","28","29","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47" }; }
    static StructureItem mFieldF6155 = null;
    static StructureItem getFieldF6155() { initCodeListF6155(); if (mFieldF6155 == null) initFieldF6155(); return mFieldF6155; }
    static void initFieldF6155 ()  { mFieldF6155 = new DataElement ("F6155",
            new  DataTypeValidatorString(0, 17,  new DataValueCodeListValidator(true, mCodeListF6155    ))  ); }

    static StructureItem mFieldF6162 = null;
    static StructureItem getFieldF6162() {  if (mFieldF6162 == null) initFieldF6162(); return mFieldF6162; }
    static void initFieldF6162 ()  { mFieldF6162 = new DataElement ("F6162",
            new  DataTypeValidatorDecimal(0, 18, 0)  ); }

    static String[] mCodeListF6167 = null;
    static void initCodeListF6167 () { mCodeListF6167 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14" }; }
    static StructureItem mFieldF6167 = null;
    static StructureItem getFieldF6167() { initCodeListF6167(); if (mFieldF6167 == null) initFieldF6167(); return mFieldF6167; }
    static void initFieldF6167 ()  { mFieldF6167 = new DataElement ("F6167",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6167    ))  ); }

    static StructureItem mFieldF6168 = null;
    static StructureItem getFieldF6168() {  if (mFieldF6168 == null) initFieldF6168(); return mFieldF6168; }
    static void initFieldF6168 ()  { mFieldF6168 = new DataElement ("F6168",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static String[] mCodeListF6245 = null;
    static void initCodeListF6245 () { mCodeListF6245 =
            new String[] { "1","2","3","4","5" }; }
    static StructureItem mFieldF6245 = null;
    static StructureItem getFieldF6245() { initCodeListF6245(); if (mFieldF6245 == null) initFieldF6245(); return mFieldF6245; }
    static void initFieldF6245 ()  { mFieldF6245 = new DataElement ("F6245",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6245    ))  ); }

    static StructureItem mFieldF6246 = null;
    static StructureItem getFieldF6246() {  if (mFieldF6246 == null) initFieldF6246(); return mFieldF6246; }
    static void initFieldF6246 ()  { mFieldF6246 = new DataElement ("F6246",
            new  DataTypeValidatorDecimal(3, 3, 0)  ); }

    static String[] mCodeListF6311 = null;
    static void initCodeListF6311 () { mCodeListF6311 =
            new String[] { "AAA","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ABO","ABP","ABQ","ABR","ABS","ABT","ABU","ABV","ABW","ABX","ABY","ABZ","ACA","ACB","ACC","ACD","ACE","ACF","ACG","ACH","ASW","CH","CHW","CN","CS","CT","DEN","DT","DV","DX","EN","FO","IV","LAO","LC","LGL","LL","LMT","PAL","PC","PD","PL","PLL","RL","SE","SH","SM","SO","SPG","SR","ST","SU","SV","TE","TL","TR","VOL","WT","WX" }; }
    static StructureItem mFieldF6311 = null;
    static StructureItem getFieldF6311() { initCodeListF6311(); if (mFieldF6311 == null) initFieldF6311(); return mFieldF6311; }
    static void initFieldF6311 ()  { mFieldF6311 = new DataElement ("F6311",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6311    ))  ); }

    static String[] mCodeListF6313 = null;
    static void initCodeListF6313 () { mCodeListF6313 =
            new String[] { "A","AAA","AAB","AAC","AAD","AAE","AAF","AAG","AAH","AAI","AAJ","AAK","AAL","AAM","AAN","AAO","AAP","AAQ","AAR","AAS","AAT","AAU","AAV","AAW","AAX","AAY","AAZ","ABA","ABB","ABC","ABD","ABE","ABF","ABG","ABH","ABI","ABJ","ABK","ABL","ABM","ABN","ABO","ABQ","ABR","ABS","ABU","ABV","ABW","ABX","ABY","ABZ","ACA","ACB","ACC","ACD","ACE","ACF","ACG","ACH","ACI","ACJ","ACK","ACL","ACM","ACN","ACO","ACP","ACQ","ACR","ACS","ACT","ACU","ACV","ACW","ACX","ACY","ACZ","ADA","ADB","ADC","ADD","ADE","ADF","ADG","ADH","ADI","ADJ","ADK","ADL","ADM","ADN","ADO","ADP","ADQ","ADR","ADS","ADT","ADU","ADV","ADW","ADX","ADY","ADZ","AEA","AEB","AEC","AED","AEE","AEF","AEG","AEH","AEI","AEJ","AEK","AEM","AEN","AEO","AEP","AEQ","AER","AET","AEU","AEV","AEW","AEX","AEY","AEZ","AF","AFA","AFB","AFC","AFD","AFE","AFF","B","BL","BND","BR","BRA","BRE","BS","BSW","BW","CHN","CM","CT","CV","CZ","D","DI","DL","DN","DP","DR","DS","DW","E","EA","F","FI","FL","FN","FV","G","GG","GW","HF","HM","HT","IB","ID","L","LM","LN","LND","M","MO","MW","N","OD","PRS","PTN","RA","RF","RJ","RMW","RP","RUN","RY","SQ","T","TC","TH","TN","TT","U","VH","VW","WA","WD","WM","WT","WU","XH","XQ","XZ","YS","ZAL","ZAS","ZB","ZBI","ZC","ZCA","ZCB","ZCE","ZCL","ZCO","ZCR","ZCU","ZFE","ZFS","ZGE","ZH","ZK","ZMG","ZMN","ZMO","ZN","ZNA","ZNB","ZNI","ZO","ZP","ZPB","ZS","ZSB","ZSE","ZSI","ZSL","ZSN","ZTA","ZTE","ZTI","ZV","ZW","ZWA","ZZN","ZZR","ZZZ" }; }
    static StructureItem mFieldF6313 = null;
    static StructureItem getFieldF6313() { initCodeListF6313(); if (mFieldF6313 == null) initFieldF6313(); return mFieldF6313; }
    static void initFieldF6313 ()  { mFieldF6313 = new DataElement ("F6313",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6313    ))  ); }

    static StructureItem mFieldF6314 = null;
    static StructureItem getFieldF6314() {  if (mFieldF6314 == null) initFieldF6314(); return mFieldF6314; }
    static void initFieldF6314 ()  { mFieldF6314 = new DataElement ("F6314",
            new  DataTypeValidatorString(0, 18,  null  )  ); }

    static String[] mCodeListF6321 = null;
    static void initCodeListF6321 () { mCodeListF6321 =
            new String[] { "3","4","5","6","7","8","10","11","12","13","15" }; }
    static StructureItem mFieldF6321 = null;
    static StructureItem getFieldF6321() { initCodeListF6321(); if (mFieldF6321 == null) initFieldF6321(); return mFieldF6321; }
    static void initFieldF6321 ()  { mFieldF6321 = new DataElement ("F6321",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6321    ))  ); }

    static String[] mCodeListF6341 = null;
    static void initCodeListF6341 () { mCodeListF6341 =
            new String[] { "AAA","AAB","AMS","ARG","AST","AUS","BEL","CAN","CAR","CIE","DEN","ECR","FIN","FRA","IMF","LNF","LNS","MIL","NOR","NYC","PHI","SRE","SWE","ZUR" }; }
    static StructureItem mFieldF6341 = null;
    static StructureItem getFieldF6341() { initCodeListF6341(); if (mFieldF6341 == null) initFieldF6341(); return mFieldF6341; }
    static void initFieldF6341 ()  { mFieldF6341 = new DataElement ("F6341",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6341    ))  ); }

    static String[] mCodeListF6343 = null;
    static void initCodeListF6343 () { mCodeListF6343 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18" }; }
    static StructureItem mFieldF6343 = null;
    static StructureItem getFieldF6343() { initCodeListF6343(); if (mFieldF6343 == null) initFieldF6343(); return mFieldF6343; }
    static void initFieldF6343 ()  { mFieldF6343 = new DataElement ("F6343",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6343    ))  ); }

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
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6347    ))  ); }

    static StructureItem mFieldF6348 = null;
    static StructureItem getFieldF6348() {  if (mFieldF6348 == null) initFieldF6348(); return mFieldF6348; }
    static void initFieldF6348 ()  { mFieldF6348 = new DataElement ("F6348",
            new  DataTypeValidatorDecimal(0, 4, 0)  ); }

    static StructureItem mFieldF6350 = null;
    static StructureItem getFieldF6350() {  if (mFieldF6350 == null) initFieldF6350(); return mFieldF6350; }
    static void initFieldF6350 ()  { mFieldF6350 = new DataElement ("F6350",
            new  DataTypeValidatorDecimal(0, 15, 0)  ); }

    static String[] mCodeListF6353 = null;
    static void initCodeListF6353 () { mCodeListF6353 =
            new String[] { "1","2","3","4","5","6","7" }; }
    static StructureItem mFieldF6353 = null;
    static StructureItem getFieldF6353() { initCodeListF6353(); if (mFieldF6353 == null) initFieldF6353(); return mFieldF6353; }
    static void initFieldF6353 ()  { mFieldF6353 = new DataElement ("F6353",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF6353    ))  ); }

    static StructureItem mFieldF6411 = null;
    static StructureItem getFieldF6411() {  if (mFieldF6411 == null) initFieldF6411(); return mFieldF6411; }
    static void initFieldF6411 ()  { mFieldF6411 = new DataElement ("F6411",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF6432 = null;
    static StructureItem getFieldF6432() {  if (mFieldF6432 == null) initFieldF6432(); return mFieldF6432; }
    static void initFieldF6432 ()  { mFieldF6432 = new DataElement ("F6432",
            new  DataTypeValidatorDecimal(0, 2, 0)  ); }

    static StructureItem mFieldF7064 = null;
    static StructureItem getFieldF7064() {  if (mFieldF7064 == null) initFieldF7064(); return mFieldF7064; }
    static void initFieldF7064 ()  { mFieldF7064 = new DataElement ("F7064",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF7065 = null;
    static StructureItem getFieldF7065() {  if (mFieldF7065 == null) initFieldF7065(); return mFieldF7065; }
    static void initFieldF7065 ()  { mFieldF7065 = new DataElement ("F7065",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF7085 = null;
    static void initCodeListF7085 () { mCodeListF7085 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16" }; }
    static StructureItem mFieldF7085 = null;
    static StructureItem getFieldF7085() { initCodeListF7085(); if (mFieldF7085 == null) initFieldF7085(); return mFieldF7085; }
    static void initFieldF7085 ()  { mFieldF7085 = new DataElement ("F7085",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7085    ))  ); }

    static StructureItem mFieldF7088 = null;
    static StructureItem getFieldF7088() {  if (mFieldF7088 == null) initFieldF7088(); return mFieldF7088; }
    static void initFieldF7088 ()  { mFieldF7088 = new DataElement ("F7088",
            new  DataTypeValidatorString(0, 8,  null  )  ); }

    static StructureItem mFieldF7102 = null;
    static StructureItem getFieldF7102() {  if (mFieldF7102 == null) initFieldF7102(); return mFieldF7102; }
    static void initFieldF7102 ()  { mFieldF7102 = new DataElement ("F7102",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF7106 = null;
    static StructureItem getFieldF7106() {  if (mFieldF7106 == null) initFieldF7106(); return mFieldF7106; }
    static void initFieldF7106 ()  { mFieldF7106 = new DataElement ("F7106",
            new  DataTypeValidatorDecimal(3, 3, 0)  ); }

    static StructureItem mFieldF7124 = null;
    static StructureItem getFieldF7124() {  if (mFieldF7124 == null) initFieldF7124(); return mFieldF7124; }
    static void initFieldF7124 ()  { mFieldF7124 = new DataElement ("F7124",
            new  DataTypeValidatorDecimal(4, 4, 0)  ); }

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
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","AZ","BA","BB","BC","BD","BE","BF","BG","BH","BI","BJ","BK","BL","BM","BN","BO","BP","BQ","BR","BS","BT","BU","CC","CG","CL","CR","CV","DR","DW","EC","EF","EN","GB","GN","GS","HS","IB","IN","IS","IT","IZ","MA","MF","MN","MP","NB","ON","PD","PL","PO","PV","QS","RC","RN","RU","RY","SA","SG","SK","SN","SRS","SS","ST","TG","UA","UP","VN","VP","VS","VX","ZZZ" }; }
    static StructureItem mFieldF7143 = null;
    static StructureItem getFieldF7143() { initCodeListF7143(); if (mFieldF7143 == null) initFieldF7143(); return mFieldF7143; }
    static void initFieldF7143 ()  { mFieldF7143 = new DataElement ("F7143",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7143    ))  ); }

    static StructureItem mFieldF7224 = null;
    static StructureItem getFieldF7224() {  if (mFieldF7224 == null) initFieldF7224(); return mFieldF7224; }
    static void initFieldF7224 ()  { mFieldF7224 = new DataElement ("F7224",
            new  DataTypeValidatorDecimal(0, 8, 0)  ); }

    static String[] mCodeListF7233 = null;
    static void initCodeListF7233 () { mCodeListF7233 =
            new String[] { "1","2","3","4","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","50","51","52","53","54","55","56","57","58","59","60","61","62","63","66","67","68","69","70","71","72","73","74","75","76","77" }; }
    static StructureItem mFieldF7233 = null;
    static StructureItem getFieldF7233() { initCodeListF7233(); if (mFieldF7233 == null) initFieldF7233(); return mFieldF7233; }
    static void initFieldF7233 ()  { mFieldF7233 = new DataElement ("F7233",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7233    ))  ); }

    static String[] mCodeListF7273 = null;
    static void initCodeListF7273 () { mCodeListF7273 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42" }; }
    static StructureItem mFieldF7273 = null;
    static StructureItem getFieldF7273() { initCodeListF7273(); if (mFieldF7273 == null) initFieldF7273(); return mFieldF7273; }
    static void initFieldF7273 ()  { mFieldF7273 = new DataElement ("F7273",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7273    ))  ); }

    static StructureItem mFieldF7357 = null;
    static StructureItem getFieldF7357() {  if (mFieldF7357 == null) initFieldF7357(); return mFieldF7357; }
    static void initFieldF7357 ()  { mFieldF7357 = new DataElement ("F7357",
            new  DataTypeValidatorString(0, 18,  null  )  ); }

    static String[] mCodeListF7383 = null;
    static void initCodeListF7383 () { mCodeListF7383 =
            new String[] { "1S","2S","AA","AB","AC","AD","AE","BC","BS","BT","DF","FR","IN","LE","OA","OS","OT","RI","RR","ST","TB","TP","TS","UC" }; }
    static StructureItem mFieldF7383 = null;
    static StructureItem getFieldF7383() { initCodeListF7383(); if (mFieldF7383 == null) initFieldF7383(); return mFieldF7383; }
    static void initFieldF7383 ()  { mFieldF7383 = new DataElement ("F7383",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7383    ))  ); }

    static StructureItem mFieldF7402 = null;
    static StructureItem getFieldF7402() {  if (mFieldF7402 == null) initFieldF7402(); return mFieldF7402; }
    static void initFieldF7402 ()  { mFieldF7402 = new DataElement ("F7402",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF7405 = null;
    static void initCodeListF7405 () { mCodeListF7405 =
            new String[] { "AA","AB","AC","AD","AE","AF","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","AQ","AR","AS","AT","AU","AV","AW","AX","AY","AZ","BA","BB","BC","BD","BE","BF","BG","BH","BI","BJ","BK","BL","BM","BN","BO","BP","BQ","BR","BS","BT","BU","BV","BW","BX","BY","BZ","CA","CB","CC","CD","CE","CF","CN","EE","EM","IL","ML","PN","SC","VV" }; }
    static StructureItem mFieldF7405 = null;
    static StructureItem getFieldF7405() { initCodeListF7405(); if (mFieldF7405 == null) initFieldF7405(); return mFieldF7405; }
    static void initFieldF7405 ()  { mFieldF7405 = new DataElement ("F7405",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF7405    ))  ); }

    static StructureItem mFieldF7418 = null;
    static StructureItem getFieldF7418() {  if (mFieldF7418 == null) initFieldF7418(); return mFieldF7418; }
    static void initFieldF7418 ()  { mFieldF7418 = new DataElement ("F7418",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF7419 = null;
    static StructureItem getFieldF7419() {  if (mFieldF7419 == null) initFieldF7419(); return mFieldF7419; }
    static void initFieldF7419 ()  { mFieldF7419 = new DataElement ("F7419",
            new  DataTypeValidatorString(0, 4,  null  )  ); }

    static StructureItem mFieldF7511 = null;
    static StructureItem getFieldF7511() {  if (mFieldF7511 == null) initFieldF7511(); return mFieldF7511; }
    static void initFieldF7511 ()  { mFieldF7511 = new DataElement ("F7511",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF8022 = null;
    static StructureItem getFieldF8022() {  if (mFieldF8022 == null) initFieldF8022(); return mFieldF8022; }
    static void initFieldF8022 ()  { mFieldF8022 = new DataElement ("F8022",
            new  DataTypeValidatorString(0, 26,  null  )  ); }

    static StructureItem mFieldF8023 = null;
    static StructureItem getFieldF8023() {  if (mFieldF8023 == null) initFieldF8023(); return mFieldF8023; }
    static void initFieldF8023 ()  { mFieldF8023 = new DataElement ("F8023",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static StructureItem mFieldF8028 = null;
    static StructureItem getFieldF8028() {  if (mFieldF8028 == null) initFieldF8028(); return mFieldF8028; }
    static void initFieldF8028 ()  { mFieldF8028 = new DataElement ("F8028",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF8051 = null;
    static void initCodeListF8051 () { mCodeListF8051 =
            new String[] { "1","2","10","11","12","13","14","20","21","22","23","24","25","26","27","28","30" }; }
    static StructureItem mFieldF8051 = null;
    static StructureItem getFieldF8051() { initCodeListF8051(); if (mFieldF8051 == null) initFieldF8051(); return mFieldF8051; }
    static void initFieldF8051 ()  { mFieldF8051 = new DataElement ("F8051",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8051    ))  ); }

    static String[] mCodeListF8053 = null;
    static void initCodeListF8053 () { mCodeListF8053 =
            new String[] { "AA","AB","AD","AE","AG","AH","AI","AJ","AK","AL","AM","AN","AO","AP","BL","BPN","BPY","BR","BX","CH","CN","DPA","EFP","EYP","FPN","FPR","FSU","LAR","LU","MPA","PA","PBP","PFP","PL","PPA","PST","RF","RG","RGF","RO","RR","SCA","SCB","SCC","SFA","SPP","STR","SW","TE","TP","TS","TSU","UL" }; }
    static StructureItem mFieldF8053 = null;
    static StructureItem getFieldF8053() { initCodeListF8053(); if (mFieldF8053 == null) initFieldF8053(); return mFieldF8053; }
    static void initFieldF8053 ()  { mFieldF8053 = new DataElement ("F8053",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8053    ))  ); }

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
            new String[] { "1","2","3","4","5" }; }
    static StructureItem mFieldF8077 = null;
    static StructureItem getFieldF8077() { initCodeListF8077(); if (mFieldF8077 == null) initFieldF8077(); return mFieldF8077; }
    static void initFieldF8077 ()  { mFieldF8077 = new DataElement ("F8077",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8077    ))  ); }

    static StructureItem mFieldF8078 = null;
    static StructureItem getFieldF8078() {  if (mFieldF8078 == null) initFieldF8078(); return mFieldF8078; }
    static void initFieldF8078 ()  { mFieldF8078 = new DataElement ("F8078",
            new  DataTypeValidatorString(0, 7,  null  )  ); }

    static StructureItem mFieldF8092 = null;
    static StructureItem getFieldF8092() {  if (mFieldF8092 == null) initFieldF8092(); return mFieldF8092; }
    static void initFieldF8092 ()  { mFieldF8092 = new DataElement ("F8092",
            new  DataTypeValidatorString(0, 10,  null  )  ); }

    static String[] mCodeListF8101 = null;
    static void initCodeListF8101 () { mCodeListF8101 =
            new String[] { "BS","SB","SC","SD","SF","SS","ZZZ" }; }
    static StructureItem mFieldF8101 = null;
    static StructureItem getFieldF8101() { initCodeListF8101(); if (mFieldF8101 == null) initFieldF8101(); return mFieldF8101; }
    static void initFieldF8101 ()  { mFieldF8101 = new DataElement ("F8101",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8101    ))  ); }

    static StructureItem mFieldF8126 = null;
    static StructureItem getFieldF8126() {  if (mFieldF8126 == null) initFieldF8126(); return mFieldF8126; }
    static void initFieldF8126 ()  { mFieldF8126 = new DataElement ("F8126",
            new  DataTypeValidatorString(0, 10,  null  )  ); }

    static StructureItem mFieldF8154 = null;
    static StructureItem getFieldF8154() {  if (mFieldF8154 == null) initFieldF8154(); return mFieldF8154; }
    static void initFieldF8154 ()  { mFieldF8154 = new DataElement ("F8154",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF8155 = null;
    static void initCodeListF8155 () { mCodeListF8155 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45" }; }
    static StructureItem mFieldF8155 = null;
    static StructureItem getFieldF8155() { initCodeListF8155(); if (mFieldF8155 == null) initFieldF8155(); return mFieldF8155; }
    static void initFieldF8155 ()  { mFieldF8155 = new DataElement ("F8155",
            new  DataTypeValidatorString(0, 10,  new DataValueCodeListValidator(true, mCodeListF8155    ))  ); }

    static StructureItem mFieldF8158 = null;
    static StructureItem getFieldF8158() {  if (mFieldF8158 == null) initFieldF8158(); return mFieldF8158; }
    static void initFieldF8158 ()  { mFieldF8158 = new DataElement ("F8158",
            new  DataTypeValidatorString(0, 4,  null  )  ); }

    static String[] mCodeListF8169 = null;
    static void initCodeListF8169 () { mCodeListF8169 =
            new String[] { "1","2","3","4","5","6","7","8" }; }
    static StructureItem mFieldF8169 = null;
    static StructureItem getFieldF8169() { initCodeListF8169(); if (mFieldF8169 == null) initFieldF8169(); return mFieldF8169; }
    static void initFieldF8169 ()  { mFieldF8169 = new DataElement ("F8169",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8169    ))  ); }

    static StructureItem mFieldF8178 = null;
    static StructureItem getFieldF8178() {  if (mFieldF8178 == null) initFieldF8178(); return mFieldF8178; }
    static void initFieldF8178 ()  { mFieldF8178 = new DataElement ("F8178",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF8179 = null;
    static void initCodeListF8179 () { mCodeListF8179 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48" }; }
    static StructureItem mFieldF8179 = null;
    static StructureItem getFieldF8179() { initCodeListF8179(); if (mFieldF8179 == null) initFieldF8179(); return mFieldF8179; }
    static void initFieldF8179 ()  { mFieldF8179 = new DataElement ("F8179",
            new  DataTypeValidatorString(0, 8,  new DataValueCodeListValidator(true, mCodeListF8179    ))  ); }

    static StructureItem mFieldF8186 = null;
    static StructureItem getFieldF8186() {  if (mFieldF8186 == null) initFieldF8186(); return mFieldF8186; }
    static void initFieldF8186 ()  { mFieldF8186 = new DataElement ("F8186",
            new  DataTypeValidatorString(4, 4,  null  )  ); }

    static StructureItem mFieldF8211 = null;
    static StructureItem getFieldF8211() {  if (mFieldF8211 == null) initFieldF8211(); return mFieldF8211; }
    static void initFieldF8211 ()  { mFieldF8211 = new DataElement ("F8211",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF8212 = null;
    static StructureItem getFieldF8212() {  if (mFieldF8212 == null) initFieldF8212(); return mFieldF8212; }
    static void initFieldF8212 ()  { mFieldF8212 = new DataElement ("F8212",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static StructureItem mFieldF8213 = null;
    static StructureItem getFieldF8213() {  if (mFieldF8213 == null) initFieldF8213(); return mFieldF8213; }
    static void initFieldF8213 ()  { mFieldF8213 = new DataElement ("F8213",
            new  DataTypeValidatorString(0, 9,  null  )  ); }

    static StructureItem mFieldF8246 = null;
    static StructureItem getFieldF8246() {  if (mFieldF8246 == null) initFieldF8246(); return mFieldF8246; }
    static void initFieldF8246 ()  { mFieldF8246 = new DataElement ("F8246",
            new  DataTypeValidatorString(0, 4,  null  )  ); }

    static String[] mCodeListF8249 = null;
    static void initCodeListF8249 () { mCodeListF8249 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14" }; }
    static StructureItem mFieldF8249 = null;
    static StructureItem getFieldF8249() { initCodeListF8249(); if (mFieldF8249 == null) initFieldF8249(); return mFieldF8249; }
    static void initFieldF8249 ()  { mFieldF8249 = new DataElement ("F8249",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8249    ))  ); }

    static StructureItem mFieldF8255 = null;
    static StructureItem getFieldF8255() {  if (mFieldF8255 == null) initFieldF8255(); return mFieldF8255; }
    static void initFieldF8255 ()  { mFieldF8255 = new DataElement ("F8255",
            new  DataTypeValidatorString(0, 3,  null  )  ); }

    static StructureItem mFieldF8260 = null;
    static StructureItem getFieldF8260() {  if (mFieldF8260 == null) initFieldF8260(); return mFieldF8260; }
    static void initFieldF8260 ()  { mFieldF8260 = new DataElement ("F8260",
            new  DataTypeValidatorString(0, 17,  null  )  ); }

    static String[] mCodeListF8273 = null;
    static void initCodeListF8273 () { mCodeListF8273 =
            new String[] { "ADR","ADS","AGS","ANR","ARD","CFR","COM","GVE","GVS","ICA","IMD","RGE","RID","TEC","UI","ZZZ" }; }
    static StructureItem mFieldF8273 = null;
    static StructureItem getFieldF8273() { initCodeListF8273(); if (mFieldF8273 == null) initFieldF8273(); return mFieldF8273; }
    static void initFieldF8273 ()  { mFieldF8273 = new DataElement ("F8273",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8273    ))  ); }

    static String[] mCodeListF8275 = null;
    static void initCodeListF8275 () { mCodeListF8275 =
            new String[] { "1","2","3","4","5","6","7","8" }; }
    static StructureItem mFieldF8275 = null;
    static StructureItem getFieldF8275() { initCodeListF8275(); if (mFieldF8275 == null) initFieldF8275(); return mFieldF8275; }
    static void initFieldF8275 ()  { mFieldF8275 = new DataElement ("F8275",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8275    ))  ); }

    static String[] mCodeListF8281 = null;
    static void initCodeListF8281 () { mCodeListF8281 =
            new String[] { "1","2","3" }; }
    static StructureItem mFieldF8281 = null;
    static StructureItem getFieldF8281() { initCodeListF8281(); if (mFieldF8281 == null) initFieldF8281(); return mFieldF8281; }
    static void initFieldF8281 ()  { mFieldF8281 = new DataElement ("F8281",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8281    ))  ); }

    static String[] mCodeListF8323 = null;
    static void initCodeListF8323 () { mCodeListF8323 =
            new String[] { "1","2","3" }; }
    static StructureItem mFieldF8323 = null;
    static StructureItem getFieldF8323() { initCodeListF8323(); if (mFieldF8323 == null) initFieldF8323(); return mFieldF8323; }
    static void initFieldF8323 ()  { mFieldF8323 = new DataElement ("F8323",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8323    ))  ); }

    static String[] mCodeListF8325 = null;
    static void initCodeListF8325 () { mCodeListF8325 =
            new String[] { "1","2","3","4","5","6","7","8","9" }; }
    static StructureItem mFieldF8325 = null;
    static StructureItem getFieldF8325() { initCodeListF8325(); if (mFieldF8325 == null) initFieldF8325(); return mFieldF8325; }
    static void initFieldF8325 ()  { mFieldF8325 = new DataElement ("F8325",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8325    ))  ); }

    static StructureItem mFieldF8332 = null;
    static StructureItem getFieldF8332() {  if (mFieldF8332 == null) initFieldF8332(); return mFieldF8332; }
    static void initFieldF8332 ()  { mFieldF8332 = new DataElement ("F8332",
            new  DataTypeValidatorString(0, 26,  null  )  ); }

    static StructureItem mFieldF8334 = null;
    static StructureItem getFieldF8334() {  if (mFieldF8334 == null) initFieldF8334(); return mFieldF8334; }
    static void initFieldF8334 ()  { mFieldF8334 = new DataElement ("F8334",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF8335 = null;
    static void initCodeListF8335 () { mCodeListF8335 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","31","32","33","41","42","43","44" }; }
    static StructureItem mFieldF8335 = null;
    static StructureItem getFieldF8335() { initCodeListF8335(); if (mFieldF8335 == null) initFieldF8335(); return mFieldF8335; }
    static void initFieldF8335 ()  { mFieldF8335 = new DataElement ("F8335",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8335    ))  ); }

    static String[] mCodeListF8339 = null;
    static void initCodeListF8339 () { mCodeListF8339 =
            new String[] { "1","2","3" }; }
    static StructureItem mFieldF8339 = null;
    static StructureItem getFieldF8339() { initCodeListF8339(); if (mFieldF8339 == null) initFieldF8339(); return mFieldF8339; }
    static void initFieldF8339 ()  { mFieldF8339 = new DataElement ("F8339",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8339    ))  ); }

    static String[] mCodeListF8341 = null;
    static void initCodeListF8341 () { mCodeListF8341 =
            new String[] { "1","2" }; }
    static StructureItem mFieldF8341 = null;
    static StructureItem getFieldF8341() { initCodeListF8341(); if (mFieldF8341 == null) initFieldF8341(); return mFieldF8341; }
    static void initFieldF8341 ()  { mFieldF8341 = new DataElement ("F8341",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8341    ))  ); }

    static StructureItem mFieldF8351 = null;
    static StructureItem getFieldF8351() {  if (mFieldF8351 == null) initFieldF8351(); return mFieldF8351; }
    static void initFieldF8351 ()  { mFieldF8351 = new DataElement ("F8351",
            new  DataTypeValidatorString(0, 7,  null  )  ); }

    static StructureItem mFieldF8364 = null;
    static StructureItem getFieldF8364() {  if (mFieldF8364 == null) initFieldF8364(); return mFieldF8364; }
    static void initFieldF8364 ()  { mFieldF8364 = new DataElement ("F8364",
            new  DataTypeValidatorString(0, 6,  null  )  ); }

    static StructureItem mFieldF8410 = null;
    static StructureItem getFieldF8410() {  if (mFieldF8410 == null) initFieldF8410(); return mFieldF8410; }
    static void initFieldF8410 ()  { mFieldF8410 = new DataElement ("F8410",
            new  DataTypeValidatorString(0, 4,  null  )  ); }

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
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8457    ))  ); }

    static String[] mCodeListF8459 = null;
    static void initCodeListF8459 () { mCodeListF8459 =
            new String[] { "A","B","S","X","ZZZ" }; }
    static StructureItem mFieldF8459 = null;
    static StructureItem getFieldF8459() { initCodeListF8459(); if (mFieldF8459 == null) initFieldF8459(); return mFieldF8459; }
    static void initFieldF8459 ()  { mFieldF8459 = new DataElement ("F8459",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF8459    ))  ); }

    static StructureItem mFieldF9302 = null;
    static StructureItem getFieldF9302() {  if (mFieldF9302 == null) initFieldF9302(); return mFieldF9302; }
    static void initFieldF9302 ()  { mFieldF9302 = new DataElement ("F9302",
            new  DataTypeValidatorString(0, 35,  null  )  ); }

    static String[] mCodeListF9303 = null;
    static void initCodeListF9303 () { mCodeListF9303 =
            new String[] { "AA","AB","AC","CA","CU","SH","TO" }; }
    static StructureItem mFieldF9303 = null;
    static StructureItem getFieldF9303() { initCodeListF9303(); if (mFieldF9303 == null) initFieldF9303(); return mFieldF9303; }
    static void initFieldF9303 ()  { mFieldF9303 = new DataElement ("F9303",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF9303    ))  ); }

    static StructureItem mFieldF9308 = null;
    static StructureItem getFieldF9308() {  if (mFieldF9308 == null) initFieldF9308(); return mFieldF9308; }
    static void initFieldF9308 ()  { mFieldF9308 = new DataElement ("F9308",
            new  DataTypeValidatorString(0, 10,  null  )  ); }

    static String[] mCodeListF9353 = null;
    static void initCodeListF9353 () { mCodeListF9353 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13" }; }
    static StructureItem mFieldF9353 = null;
    static StructureItem getFieldF9353() { initCodeListF9353(); if (mFieldF9353 == null) initFieldF9353(); return mFieldF9353; }
    static void initFieldF9353 ()  { mFieldF9353 = new DataElement ("F9353",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF9353    ))  ); }

    static String[] mCodeListF9411 = null;
    static void initCodeListF9411 () { mCodeListF9411 =
            new String[] { "1","2","3","4","5","6","7" }; }
    static StructureItem mFieldF9411 = null;
    static StructureItem getFieldF9411() { initCodeListF9411(); if (mFieldF9411 == null) initFieldF9411(); return mFieldF9411; }
    static void initFieldF9411 ()  { mFieldF9411 = new DataElement ("F9411",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF9411    ))  ); }

    static String[] mCodeListF9415 = null;
    static void initCodeListF9415 () { mCodeListF9415 =
            new String[] { "1","2","3","4","5","6","7","8","9","10","11","12","13" }; }
    static StructureItem mFieldF9415 = null;
    static StructureItem getFieldF9415() { initCodeListF9415(); if (mFieldF9415 == null) initFieldF9415(); return mFieldF9415; }
    static void initFieldF9415 ()  { mFieldF9415 = new DataElement ("F9415",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF9415    ))  ); }

    static String[] mCodeListF9417 = null;
    static void initCodeListF9417 () { mCodeListF9417 =
            new String[] { "1","2","3","4","5" }; }
    static StructureItem mFieldF9417 = null;
    static StructureItem getFieldF9417() { initCodeListF9417(); if (mFieldF9417 == null) initFieldF9417(); return mFieldF9417; }
    static void initFieldF9417 ()  { mFieldF9417 = new DataElement ("F9417",
            new  DataTypeValidatorString(0, 3,  new DataValueCodeListValidator(true, mCodeListF9417    ))  ); }

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

    static StructureItem mFieldC100 = null;
    static StructureItem getFieldC100() {  if (mFieldC100 == null) initFieldC100(); return mFieldC100; }
    static void initFieldC100 ()
    {
        mFieldC100 = new Composite ("C100",
                new Particle[]{
                        new Particle("F4053", getFieldF4053(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F4052", getFieldF4052(), 0, 1, 2, false, new String[]{}),			});
    }

    static StructureItem mFieldC106 = null;
    static StructureItem getFieldC106() {  if (mFieldC106 == null) initFieldC106(); return mFieldC106; }
    static void initFieldC106 ()
    {
        mFieldC106 = new Composite ("C106",
                new Particle[]{
                        new Particle("F1004", getFieldF1004(), 0, 1, 1, false, new String[]{}),				new Particle("F1056", getFieldF1056(), 0, 1, 1, false, new String[]{}),				new Particle("F1060", getFieldF1060(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mFieldC200 = null;
    static StructureItem getFieldC200() {  if (mFieldC200 == null) initFieldC200(); return mFieldC200; }
    static void initFieldC200 ()
    {
        mFieldC200 = new Composite ("C200",
                new Particle[]{
                        new Particle("F8023", getFieldF8023(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F8022", getFieldF8022(), 0, 1, 1, false, new String[]{}),				new Particle("F4237", getFieldF4237(), 0, 1, 1, false, new String[]{}),				new Particle("F7140", getFieldF7140(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC203 = null;
    static StructureItem getFieldC203() {  if (mFieldC203 == null) initFieldC203(); return mFieldC203; }
    static void initFieldC203 ()
    {
        mFieldC203 = new Composite ("C203",
                new Particle[]{
                        new Particle("F5243", getFieldF5243(), 1, 1, 1, false, new String[]{}),				new Particle("F1131_1", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_1", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F5242", getFieldF5242(), 0, 1, 1, false, new String[]{}),				new Particle("F5275_1", getFieldF5275(), 0, 1, 1, false, new String[]{}),				new Particle("F1131_2", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_2", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F5275_2", getFieldF5275(), 0, 1, 1, false, new String[]{}),				new Particle("F1131_3", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_3", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC205 = null;
    static StructureItem getFieldC205() {  if (mFieldC205 == null) initFieldC205(); return mFieldC205; }
    static void initFieldC205 ()
    {
        mFieldC205 = new Composite ("C205",
                new Particle[]{
                        new Particle("F8351", getFieldF8351(), 1, 1, 1, false, new String[]{}),				new Particle("F8078", getFieldF8078(), 0, 1, 1, false, new String[]{}),				new Particle("F8092", getFieldF8092(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mFieldC211 = null;
    static StructureItem getFieldC211() {  if (mFieldC211 == null) initFieldC211(); return mFieldC211; }
    static void initFieldC211 ()
    {
        mFieldC211 = new Composite ("C211",
                new Particle[]{
                        new Particle("F6411", getFieldF6411(), 1, 1, 1, false, new String[]{}),				new Particle("F6168", getFieldF6168(), 0, 1, 1, false, new String[]{}),				new Particle("F6140", getFieldF6140(), 0, 1, 1, false, new String[]{}),				new Particle("F6008", getFieldF6008(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC212 = null;
    static StructureItem getFieldC212() {  if (mFieldC212 == null) initFieldC212(); return mFieldC212; }
    static void initFieldC212 ()
    {
        mFieldC212 = new Composite ("C212",
                new Particle[]{
                        new Particle("F7140", getFieldF7140(), 0, 1, 1, false, new String[]{}),				new Particle("F7143", getFieldF7143(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC213 = null;
    static StructureItem getFieldC213() {  if (mFieldC213 == null) initFieldC213(); return mFieldC213; }
    static void initFieldC213 ()
    {
        mFieldC213 = new Composite ("C213",
                new Particle[]{
                        new Particle("F7224", getFieldF7224(), 0, 1, 1, false, new String[]{}),				new Particle("F7065", getFieldF7065(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F7064", getFieldF7064(), 0, 1, 1, false, new String[]{}),				new Particle("F7233", getFieldF7233(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC215 = null;
    static StructureItem getFieldC215() {  if (mFieldC215 == null) initFieldC215(); return mFieldC215; }
    static void initFieldC215 ()
    {
        mFieldC215 = new Composite ("C215",
                new Particle[]{
                        new Particle("F9303", getFieldF9303(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F9302", getFieldF9302(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC218 = null;
    static StructureItem getFieldC218() {  if (mFieldC218 == null) initFieldC218(); return mFieldC218; }
    static void initFieldC218 ()
    {
        mFieldC218 = new Composite ("C218",
                new Particle[]{
                        new Particle("F7419", getFieldF7419(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F7418", getFieldF7418(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC219 = null;
    static StructureItem getFieldC219() {  if (mFieldC219 == null) initFieldC219(); return mFieldC219; }
    static void initFieldC219 ()
    {
        mFieldC219 = new Composite ("C219",
                new Particle[]{
                        new Particle("F8335", getFieldF8335(), 0, 1, 1, false, new String[]{}),				new Particle("F8334", getFieldF8334(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mFieldC223 = null;
    static StructureItem getFieldC223() {  if (mFieldC223 == null) initFieldC223(); return mFieldC223; }
    static void initFieldC223 ()
    {
        mFieldC223 = new Composite ("C223",
                new Particle[]{
                        new Particle("F7106", getFieldF7106(), 0, 1, 1, false, new String[]{}),				new Particle("F6411", getFieldF6411(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mFieldC229 = null;
    static StructureItem getFieldC229() {  if (mFieldC229 == null) initFieldC229(); return mFieldC229; }
    static void initFieldC229 ()
    {
        mFieldC229 = new Composite ("C229",
                new Particle[]{
                        new Particle("F5237", getFieldF5237(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC231 = null;
    static StructureItem getFieldC231() {  if (mFieldC231 == null) initFieldC231(); return mFieldC231; }
    static void initFieldC231 ()
    {
        mFieldC231 = new Composite ("C231",
                new Particle[]{
                        new Particle("F4215", getFieldF4215(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC232 = null;
    static StructureItem getFieldC232() {  if (mFieldC232 == null) initFieldC232(); return mFieldC232; }
    static void initFieldC232 ()
    {
        mFieldC232 = new Composite ("C232",
                new Particle[]{
                        new Particle("F9415", getFieldF9415(), 0, 1, 1, false, new String[]{}),				new Particle("F9411", getFieldF9411(), 0, 1, 1, false, new String[]{}),				new Particle("F9417", getFieldF9417(), 0, 1, 1, false, new String[]{}),				new Particle("F9353", getFieldF9353(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC233 = null;
    static StructureItem getFieldC233() {  if (mFieldC233 == null) initFieldC233(); return mFieldC233; }
    static void initFieldC233 ()
    {
        mFieldC233 = new Composite ("C233",
                new Particle[]{
                        new Particle("F7273_1", getFieldF7273(), 1, 1, 1, false, new String[]{}),				new Particle("F1131_1", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_1", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F7273_2", getFieldF7273(), 0, 1, 1, false, new String[]{}),				new Particle("F1131_2", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055_2", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC234 = null;
    static StructureItem getFieldC234() {  if (mFieldC234 == null) initFieldC234(); return mFieldC234; }
    static void initFieldC234 ()
    {
        mFieldC234 = new Composite ("C234",
                new Particle[]{
                        new Particle("F7124", getFieldF7124(), 0, 1, 1, false, new String[]{}),				new Particle("F7088", getFieldF7088(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC235 = null;
    static StructureItem getFieldC235() {  if (mFieldC235 == null) initFieldC235(); return mFieldC235; }
    static void initFieldC235 ()
    {
        mFieldC235 = new Composite ("C235",
                new Particle[]{
                        new Particle("F8158", getFieldF8158(), 0, 1, 1, false, new String[]{}),				new Particle("F8186", getFieldF8186(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC236 = null;
    static StructureItem getFieldC236() {  if (mFieldC236 == null) initFieldC236(); return mFieldC236; }
    static void initFieldC236 ()
    {
        mFieldC236 = new Composite ("C236",
                new Particle[]{
                        new Particle("F8246", getFieldF8246(), 0, 1, 3, false, new String[]{}),			});
    }

    static StructureItem mFieldC237 = null;
    static StructureItem getFieldC237() {  if (mFieldC237 == null) initFieldC237(); return mFieldC237; }
    static void initFieldC237 ()
    {
        mFieldC237 = new Composite ("C237",
                new Particle[]{
                        new Particle("F8260", getFieldF8260(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3207", getFieldF3207(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC239 = null;
    static StructureItem getFieldC239() {  if (mFieldC239 == null) initFieldC239(); return mFieldC239; }
    static void initFieldC239 ()
    {
        mFieldC239 = new Composite ("C239",
                new Particle[]{
                        new Particle("F6246", getFieldF6246(), 0, 1, 1, false, new String[]{}),				new Particle("F6411", getFieldF6411(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC270 = null;
    static StructureItem getFieldC270() {  if (mFieldC270 == null) initFieldC270(); return mFieldC270; }
    static void initFieldC270 ()
    {
        mFieldC270 = new Composite ("C270",
                new Particle[]{
                        new Particle("F6069", getFieldF6069(), 1, 1, 1, false, new String[]{}),				new Particle("F6066", getFieldF6066(), 1, 1, 1, false, new String[]{}),				new Particle("F6411", getFieldF6411(), 0, 1, 1, false, new String[]{}),			});
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
                        new Particle("F1004", getFieldF1004(), 0, 1, 1, false, new String[]{}),				new Particle("F1373", getFieldF1373(), 0, 1, 1, false, new String[]{}),				new Particle("F1366", getFieldF1366(), 0, 1, 1, false, new String[]{}),				new Particle("F3453", getFieldF3453(), 0, 1, 1, false, new String[]{}),				new Particle("F1056", getFieldF1056(), 0, 1, 1, false, new String[]{}),				new Particle("F1060", getFieldF1060(), 0, 1, 1, false, new String[]{}),			});
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
                        new Particle("F1153", getFieldF1153(), 1, 1, 1, false, new String[]{}),				new Particle("F1154", getFieldF1154(), 0, 1, 1, false, new String[]{}),				new Particle("F1156", getFieldF1156(), 0, 1, 1, false, new String[]{}),				new Particle("F4000", getFieldF4000(), 0, 1, 1, false, new String[]{}),				new Particle("F1060", getFieldF1060(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mFieldC523 = null;
    static StructureItem getFieldC523() {  if (mFieldC523 == null) initFieldC523(); return mFieldC523; }
    static void initFieldC523 ()
    {
        mFieldC523 = new Composite ("C523",
                new Particle[]{
                        new Particle("F6350", getFieldF6350(), 0, 1, 1, false, new String[]{}),				new Particle("F6353", getFieldF6353(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC524 = null;
    static StructureItem getFieldC524() {  if (mFieldC524 == null) initFieldC524(); return mFieldC524; }
    static void initFieldC524 ()
    {
        mFieldC524 = new Composite ("C524",
                new Particle[]{
                        new Particle("F4079", getFieldF4079(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F4078", getFieldF4078(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC528 = null;
    static StructureItem getFieldC528() {  if (mFieldC528 == null) initFieldC528(); return mFieldC528; }
    static void initFieldC528 ()
    {
        mFieldC528 = new Composite ("C528",
                new Particle[]{
                        new Particle("F7357", getFieldF7357(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC536 = null;
    static StructureItem getFieldC536() {  if (mFieldC536 == null) initFieldC536(); return mFieldC536; }
    static void initFieldC536 ()
    {
        mFieldC536 = new Composite ("C536",
                new Particle[]{
                        new Particle("F4065", getFieldF4065(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC537 = null;
    static StructureItem getFieldC537() {  if (mFieldC537 == null) initFieldC537(); return mFieldC537; }
    static void initFieldC537 ()
    {
        mFieldC537 = new Composite ("C537",
                new Particle[]{
                        new Particle("F4219", getFieldF4219(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC553 = null;
    static StructureItem getFieldC553() {  if (mFieldC553 == null) initFieldC553(); return mFieldC553; }
    static void initFieldC553 ()
    {
        mFieldC553 = new Composite ("C553",
                new Particle[]{
                        new Particle("F3233", getFieldF3233(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),				new Particle("F3232", getFieldF3232(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC554 = null;
    static StructureItem getFieldC554() {  if (mFieldC554 == null) initFieldC554(); return mFieldC554; }
    static void initFieldC554 ()
    {
        mFieldC554 = new Composite ("C554",
                new Particle[]{
                        new Particle("F5243", getFieldF5243(), 0, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC703 = null;
    static StructureItem getFieldC703() {  if (mFieldC703 == null) initFieldC703(); return mFieldC703; }
    static void initFieldC703 ()
    {
        mFieldC703 = new Composite ("C703",
                new Particle[]{
                        new Particle("F7085", getFieldF7085(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mFieldC827 = null;
    static StructureItem getFieldC827() {  if (mFieldC827 == null) initFieldC827(); return mFieldC827; }
    static void initFieldC827 ()
    {
        mFieldC827 = new Composite ("C827",
                new Particle[]{
                        new Particle("F7511", getFieldF7511(), 1, 1, 1, false, new String[]{}),				new Particle("F1131", getFieldF1131(), 0, 1, 1, false, new String[]{}),				new Particle("F3055", getFieldF3055(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mStructureBGM = null;
    static StructureItem getStructureBGM() {  if (mStructureBGM == null) initStructureBGM(); return mStructureBGM; }
    static void initStructureBGM ()
    {
        mStructureBGM = new Segment ("BGM","", "",
                new Particle[]{
                        new Particle("C002", getFieldC002(), 0, 1, 1, false, new String[]{}),				new Particle("C106", getFieldC106(), 0, 1, 1, false, new String[]{}),				new Particle("F1225", getFieldF1225(), 0, 1, 1, false, new String[]{}),				new Particle("F4343", getFieldF4343(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mStructureCPI = null;
    static StructureItem getStructureCPI() {  if (mStructureCPI == null) initStructureCPI(); return mStructureCPI; }
    static void initStructureCPI ()
    {
        mStructureCPI = new Segment ("CPI","", "",
                new Particle[]{
                        new Particle("C229", getFieldC229(), 0, 1, 1, false, new String[]{}),				new Particle("C231", getFieldC231(), 0, 1, 1, false, new String[]{}),				new Particle("F4237", getFieldF4237(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mStructureDGS = null;
    static StructureItem getStructureDGS() {  if (mStructureDGS == null) initStructureDGS(); return mStructureDGS; }
    static void initStructureDGS ()
    {
        mStructureDGS = new Segment ("DGS","", "",
                new Particle[]{
                        new Particle("F8273", getFieldF8273(), 0, 1, 1, false, new String[]{}),				new Particle("C205", getFieldC205(), 0, 1, 1, false, new String[]{}),				new Particle("C234", getFieldC234(), 0, 1, 1, false, new String[]{}),				new Particle("C223", getFieldC223(), 0, 1, 1, false, new String[]{}),				new Particle("F8339", getFieldF8339(), 0, 1, 1, false, new String[]{}),				new Particle("F8364", getFieldF8364(), 0, 1, 1, false, new String[]{}),				new Particle("F8410", getFieldF8410(), 0, 1, 1, false, new String[]{}),				new Particle("F8126", getFieldF8126(), 0, 1, 1, false, new String[]{}),				new Particle("C235", getFieldC235(), 0, 1, 1, false, new String[]{}),				new Particle("C236", getFieldC236(), 0, 1, 1, false, new String[]{}),				new Particle("F8255", getFieldF8255(), 0, 1, 1, false, new String[]{}),				new Particle("F8325", getFieldF8325(), 0, 1, 1, false, new String[]{}),				new Particle("F8211", getFieldF8211(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureDIM = null;
    static StructureItem getStructureDIM() {  if (mStructureDIM == null) initStructureDIM(); return mStructureDIM; }
    static void initStructureDIM ()
    {
        mStructureDIM = new Segment ("DIM","", "",
                new Particle[]{
                        new Particle("F6145", getFieldF6145(), 1, 1, 1, false, new String[]{}),				new Particle("C211", getFieldC211(), 1, 1, 1, false, new String[]{}),			});
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

    static StructureItem mStructureEQA = null;
    static StructureItem getStructureEQA() {  if (mStructureEQA == null) initStructureEQA(); return mStructureEQA; }
    static void initStructureEQA ()
    {
        mStructureEQA = new Segment ("EQA","", "",
                new Particle[]{
                        new Particle("F8053", getFieldF8053(), 1, 1, 1, false, new String[]{}),				new Particle("C237", getFieldC237(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureEQD = null;
    static StructureItem getStructureEQD() {  if (mStructureEQD == null) initStructureEQD(); return mStructureEQD; }
    static void initStructureEQD ()
    {
        mStructureEQD = new Segment ("EQD","", "",
                new Particle[]{
                        new Particle("F8053", getFieldF8053(), 1, 1, 1, false, new String[]{}),				new Particle("C237", getFieldC237(), 0, 1, 1, false, new String[]{}),				new Particle("C224", getFieldC224(), 0, 1, 1, false, new String[]{}),				new Particle("F8077", getFieldF8077(), 0, 1, 1, false, new String[]{}),				new Particle("F8249", getFieldF8249(), 0, 1, 1, false, new String[]{}),				new Particle("F8169", getFieldF8169(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureEQN = null;
    static StructureItem getStructureEQN() {  if (mStructureEQN == null) initStructureEQN(); return mStructureEQN; }
    static void initStructureEQN ()
    {
        mStructureEQN = new Segment ("EQN","", "",
                new Particle[]{
                        new Particle("C523", getFieldC523(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureFTX = null;
    static StructureItem getStructureFTX() {  if (mStructureFTX == null) initStructureFTX(); return mStructureFTX; }
    static void initStructureFTX ()
    {
        mStructureFTX = new Segment ("FTX","", "",
                new Particle[]{
                        new Particle("F4451", getFieldF4451(), 1, 1, 1, false, new String[]{}),				new Particle("F4453", getFieldF4453(), 0, 1, 1, false, new String[]{}),				new Particle("C107", getFieldC107(), 0, 1, 1, false, new String[]{}),				new Particle("C108", getFieldC108(), 0, 1, 1, false, new String[]{}),				new Particle("F3453", getFieldF3453(), 0, 1, 1, false, new String[]{}),				new Particle("F4447", getFieldF4447(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureGDS = null;
    static StructureItem getStructureGDS() {  if (mStructureGDS == null) initStructureGDS(); return mStructureGDS; }
    static void initStructureGDS ()
    {
        mStructureGDS = new Segment ("GDS","", "",
                new Particle[]{
                        new Particle("C703", getFieldC703(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureGID = null;
    static StructureItem getStructureGID() {  if (mStructureGID == null) initStructureGID(); return mStructureGID; }
    static void initStructureGID ()
    {
        mStructureGID = new Segment ("GID","", "",
                new Particle[]{
                        new Particle("F1496", getFieldF1496(), 0, 1, 1, false, new String[]{}),				new Particle("C213", getFieldC213(), 0, 1, 5, false, new String[]{}),			});
    }

    static StructureItem mStructureGIN = null;
    static StructureItem getStructureGIN() {  if (mStructureGIN == null) initStructureGIN(); return mStructureGIN; }
    static void initStructureGIN ()
    {
        mStructureGIN = new Segment ("GIN","", "",
                new Particle[]{
                        new Particle("F7405", getFieldF7405(), 1, 1, 1, false, new String[]{}),				new Particle("C208", getFieldC208(), 1, 1, 5, false, new String[]{}),			});
    }

    static StructureItem mStructureGOR = null;
    static StructureItem getStructureGOR() {  if (mStructureGOR == null) initStructureGOR(); return mStructureGOR; }
    static void initStructureGOR ()
    {
        mStructureGOR = new Segment ("GOR","", "",
                new Particle[]{
                        new Particle("F8323", getFieldF8323(), 0, 1, 1, false, new String[]{}),				new Particle("C232", getFieldC232(), 0, 1, 4, false, new String[]{}),			});
    }

    static StructureItem mStructureHAN = null;
    static StructureItem getStructureHAN() {  if (mStructureHAN == null) initStructureHAN(); return mStructureHAN; }
    static void initStructureHAN ()
    {
        mStructureHAN = new Segment ("HAN","", "",
                new Particle[]{
                        new Particle("C524", getFieldC524(), 0, 1, 1, false, new String[]{}),				new Particle("C218", getFieldC218(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mStructureSEL = null;
    static StructureItem getStructureSEL() {  if (mStructureSEL == null) initStructureSEL(); return mStructureSEL; }
    static void initStructureSEL ()
    {
        mStructureSEL = new Segment ("SEL","", "",
                new Particle[]{
                        new Particle("F9308", getFieldF9308(), 0, 1, 1, false, new String[]{}),				new Particle("C215", getFieldC215(), 0, 1, 1, false, new String[]{}),				new Particle("F4517", getFieldF4517(), 0, 1, 1, false, new String[]{}),				new Particle("C208", getFieldC208(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSGP = null;
    static StructureItem getStructureSGP() {  if (mStructureSGP == null) initStructureSGP(); return mStructureSGP; }
    static void initStructureSGP ()
    {
        mStructureSGP = new Segment ("SGP","", "",
                new Particle[]{
                        new Particle("C237", getFieldC237(), 1, 1, 1, false, new String[]{}),				new Particle("F7224", getFieldF7224(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTCC = null;
    static StructureItem getStructureTCC() {  if (mStructureTCC == null) initStructureTCC(); return mStructureTCC; }
    static void initStructureTCC ()
    {
        mStructureTCC = new Segment ("TCC","", "",
                new Particle[]{
                        new Particle("C200", getFieldC200(), 0, 1, 1, false, new String[]{}),				new Particle("C203", getFieldC203(), 0, 1, 1, false, new String[]{}),				new Particle("C528", getFieldC528(), 0, 1, 1, false, new String[]{}),				new Particle("C554", getFieldC554(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTDT = null;
    static StructureItem getStructureTDT() {  if (mStructureTDT == null) initStructureTDT(); return mStructureTDT; }
    static void initStructureTDT ()
    {
        mStructureTDT = new Segment ("TDT","", "",
                new Particle[]{
                        new Particle("F8051", getFieldF8051(), 1, 1, 1, false, new String[]{}),				new Particle("F8028", getFieldF8028(), 0, 1, 1, false, new String[]{}),				new Particle("C220", getFieldC220(), 0, 1, 1, false, new String[]{}),				new Particle("C228", getFieldC228(), 0, 1, 1, false, new String[]{}),				new Particle("C040", getFieldC040(), 0, 1, 1, false, new String[]{}),				new Particle("F8101", getFieldF8101(), 0, 1, 1, false, new String[]{}),				new Particle("C401", getFieldC401(), 0, 1, 1, false, new String[]{}),				new Particle("C222", getFieldC222(), 0, 1, 1, false, new String[]{}),				new Particle("F8281", getFieldF8281(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTMD = null;
    static StructureItem getStructureTMD() {  if (mStructureTMD == null) initStructureTMD(); return mStructureTMD; }
    static void initStructureTMD ()
    {
        mStructureTMD = new Segment ("TMD","", "",
                new Particle[]{
                        new Particle("C219", getFieldC219(), 0, 1, 1, false, new String[]{}),				new Particle("F8332", getFieldF8332(), 0, 1, 1, false, new String[]{}),				new Particle("F8341", getFieldF8341(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTMP = null;
    static StructureItem getStructureTMP() {  if (mStructureTMP == null) initStructureTMP(); return mStructureTMP; }
    static void initStructureTMP ()
    {
        mStructureTMP = new Segment ("TMP","", "",
                new Particle[]{
                        new Particle("F6245", getFieldF6245(), 1, 1, 1, false, new String[]{}),				new Particle("C239", getFieldC239(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTOD = null;
    static StructureItem getStructureTOD() {  if (mStructureTOD == null) initStructureTOD(); return mStructureTOD; }
    static void initStructureTOD ()
    {
        mStructureTOD = new Segment ("TOD","", "",
                new Particle[]{
                        new Particle("F4055", getFieldF4055(), 0, 1, 1, false, new String[]{}),				new Particle("F4215", getFieldF4215(), 0, 1, 1, false, new String[]{}),				new Particle("C100", getFieldC100(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTPL = null;
    static StructureItem getStructureTPL() {  if (mStructureTPL == null) initStructureTPL(); return mStructureTPL; }
    static void initStructureTPL ()
    {
        mStructureTPL = new Segment ("TPL","", "",
                new Particle[]{
                        new Particle("C222", getFieldC222(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureTSR = null;
    static StructureItem getStructureTSR() {  if (mStructureTSR == null) initStructureTSR(); return mStructureTSR; }
    static void initStructureTSR ()
    {
        mStructureTSR = new Segment ("TSR","", "",
                new Particle[]{
                        new Particle("C536", getFieldC536(), 0, 1, 1, false, new String[]{}),				new Particle("C233", getFieldC233(), 0, 1, 1, false, new String[]{}),				new Particle("C537", getFieldC537(), 0, 1, 1, false, new String[]{}),				new Particle("C703", getFieldC703(), 0, 1, 1, false, new String[]{}),			});
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

    static StructureItem mStructureMessage_IFTMIN = null;
    static StructureItem getStructureMessage_IFTMIN() {  if (mStructureMessage_IFTMIN == null) initStructureMessage_IFTMIN(); return mStructureMessage_IFTMIN; }
    static void initStructureMessage_IFTMIN ()
    {
        mStructureMessage_IFTMIN = new Group ("Message_IFTMIN","", "",
                new Particle[]{
                        new Particle("UNH", getStructureUNH(), 1, 1, 1, false, new String[]{}),				new Particle("BGM", getStructureBGM(), 1, 1, 1, false, new String[]{}),				new Particle("CTA", getStructureCTA(), 0, 1, 1, false, new String[]{}),				new Particle("COM", getStructureCOM(), 0, 9, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),				new Particle("TSR", getStructureTSR(), 0, 9, 1, false, new String[]{}),				new Particle("CUX", getStructureCUX(), 0, 9, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 99, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 99, 1, false, new String[]{}),				new Particle("CNT", getStructureCNT(), 0, 9, 1, false, new String[]{}),				new Particle("DOC", getStructureDOC(), 0, 9, 1, false, new String[]{}),				new Particle("SG1", getStructureSG1(), 0, 99, 1, false, new String[]{}),				new Particle("SG2", getStructureSG2(), 0, 2, 1, false, new String[]{}),				new Particle("SG3", getStructureSG3(), 0, 999, 1, false, new String[]{}),				new Particle("SG4", getStructureSG4(), 0, 9, 1, false, new String[]{}),				new Particle("SG6", getStructureSG6(), 0, 9, 1, false, new String[]{}),				new Particle("SG7", getStructureSG7(), 0, 99, 1, false, new String[]{}),				new Particle("SG8", getStructureSG8(), 0, 99, 1, false, new String[]{}),				new Particle("SG11", getStructureSG11(), 1, 99, 1, false, new String[]{}),				new Particle("SG18", getStructureSG18(), 0, 999, 1, false, new String[]{}),				new Particle("SG37", getStructureSG37(), 0, 999, 1, false, new String[]{}),				new Particle("UNT", getStructureUNT(), 1, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG1 = null;
    static StructureItem getStructureSG1() {  if (mStructureSG1 == null) initStructureSG1(); return mStructureSG1; }
    static void initStructureSG1 ()
    {
        mStructureSG1 = new Group ("SG1","", "",
                new Particle[]{
                        new Particle("LOC", getStructureLOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG10 = null;
    static StructureItem getStructureSG10() {  if (mStructureSG10 == null) initStructureSG10(); return mStructureSG10; }
    static void initStructureSG10 ()
    {
        mStructureSG10 = new Group ("SG10","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG11 = null;
    static StructureItem getStructureSG11() {  if (mStructureSG11 == null) initStructureSG11(); return mStructureSG11; }
    static void initStructureSG11 ()
    {
        mStructureSG11 = new Group ("SG11","", "",
                new Particle[]{
                        new Particle("NAD", getStructureNAD(), 1, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 9, 1, false, new String[]{}),				new Particle("SG12", getStructureSG12(), 0, 9, 1, false, new String[]{}),				new Particle("SG13", getStructureSG13(), 0, 9, 1, false, new String[]{}),				new Particle("SG14", getStructureSG14(), 0, 99, 1, false, new String[]{}),				new Particle("SG15", getStructureSG15(), 0, 9, 1, false, new String[]{}),				new Particle("SG16", getStructureSG16(), 0, 9, 1, false, new String[]{}),				new Particle("SG17", getStructureSG17(), 0, 99, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG12 = null;
    static StructureItem getStructureSG12() {  if (mStructureSG12 == null) initStructureSG12(); return mStructureSG12; }
    static void initStructureSG12 ()
    {
        mStructureSG12 = new Group ("SG12","", "",
                new Particle[]{
                        new Particle("CTA", getStructureCTA(), 1, 1, 1, false, new String[]{}),				new Particle("COM", getStructureCOM(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG13 = null;
    static StructureItem getStructureSG13() {  if (mStructureSG13 == null) initStructureSG13(); return mStructureSG13; }
    static void initStructureSG13 ()
    {
        mStructureSG13 = new Group ("SG13","", "",
                new Particle[]{
                        new Particle("DOC", getStructureDOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG14 = null;
    static StructureItem getStructureSG14() {  if (mStructureSG14 == null) initStructureSG14(); return mStructureSG14; }
    static void initStructureSG14 ()
    {
        mStructureSG14 = new Group ("SG14","", "",
                new Particle[]{
                        new Particle("TCC", getStructureTCC(), 1, 1, 1, false, new String[]{}),				new Particle("CUX", getStructureCUX(), 0, 1, 1, false, new String[]{}),				new Particle("PRI", getStructurePRI(), 0, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),				new Particle("PCD", getStructurePCD(), 0, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 9, 1, false, new String[]{}),				new Particle("QTY", getStructureQTY(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG15 = null;
    static StructureItem getStructureSG15() {  if (mStructureSG15 == null) initStructureSG15(); return mStructureSG15; }
    static void initStructureSG15 ()
    {
        mStructureSG15 = new Group ("SG15","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG16 = null;
    static StructureItem getStructureSG16() {  if (mStructureSG16 == null) initStructureSG16(); return mStructureSG16; }
    static void initStructureSG16 ()
    {
        mStructureSG16 = new Group ("SG16","", "",
                new Particle[]{
                        new Particle("CPI", getStructureCPI(), 1, 1, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 99, 1, false, new String[]{}),				new Particle("CUX", getStructureCUX(), 0, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG17 = null;
    static StructureItem getStructureSG17() {  if (mStructureSG17 == null) initStructureSG17(); return mStructureSG17; }
    static void initStructureSG17 ()
    {
        mStructureSG17 = new Group ("SG17","", "",
                new Particle[]{
                        new Particle("TSR", getStructureTSR(), 1, 1, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 1, 1, false, new String[]{}),				new Particle("TPL", getStructureTPL(), 0, 1, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG18 = null;
    static StructureItem getStructureSG18() {  if (mStructureSG18 == null) initStructureSG18(); return mStructureSG18; }
    static void initStructureSG18 ()
    {
        mStructureSG18 = new Group ("SG18","", "",
                new Particle[]{
                        new Particle("GID", getStructureGID(), 1, 1, 1, false, new String[]{}),				new Particle("HAN", getStructureHAN(), 0, 99, 1, false, new String[]{}),				new Particle("TMP", getStructureTMP(), 0, 1, 1, false, new String[]{}),				new Particle("RNG", getStructureRNG(), 0, 1, 1, false, new String[]{}),				new Particle("TMD", getStructureTMD(), 0, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 9, 1, false, new String[]{}),				new Particle("PIA", getStructurePIA(), 0, 9, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 99, 1, false, new String[]{}),				new Particle("PCD", getStructurePCD(), 0, 9, 1, false, new String[]{}),				new Particle("SG19", getStructureSG19(), 0, 9, 1, false, new String[]{}),				new Particle("GDS", getStructureGDS(), 0, 9, 1, false, new String[]{}),				new Particle("SG20", getStructureSG20(), 0, 99, 1, false, new String[]{}),				new Particle("SG21", getStructureSG21(), 0, 99, 1, false, new String[]{}),				new Particle("SG22", getStructureSG22(), 0, 9, 1, false, new String[]{}),				new Particle("SG23", getStructureSG23(), 0, 999, 1, false, new String[]{}),				new Particle("SG24", getStructureSG24(), 0, 9, 1, false, new String[]{}),				new Particle("SG25", getStructureSG25(), 0, 9, 1, false, new String[]{}),				new Particle("SG27", getStructureSG27(), 0, 9, 1, false, new String[]{}),				new Particle("SG29", getStructureSG29(), 0, 999, 1, false, new String[]{}),				new Particle("SG31", getStructureSG31(), 0, 99, 1, false, new String[]{}),				new Particle("SG32", getStructureSG32(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG19 = null;
    static StructureItem getStructureSG19() {  if (mStructureSG19 == null) initStructureSG19(); return mStructureSG19; }
    static void initStructureSG19 ()
    {
        mStructureSG19 = new Group ("SG19","", "",
                new Particle[]{
                        new Particle("NAD", getStructureNAD(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG2 = null;
    static StructureItem getStructureSG2() {  if (mStructureSG2 == null) initStructureSG2(); return mStructureSG2; }
    static void initStructureSG2 ()
    {
        mStructureSG2 = new Group ("SG2","", "",
                new Particle[]{
                        new Particle("TOD", getStructureTOD(), 1, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG20 = null;
    static StructureItem getStructureSG20() {  if (mStructureSG20 == null) initStructureSG20(); return mStructureSG20; }
    static void initStructureSG20 ()
    {
        mStructureSG20 = new Group ("SG20","", "",
                new Particle[]{
                        new Particle("MEA", getStructureMEA(), 1, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG21 = null;
    static StructureItem getStructureSG21() {  if (mStructureSG21 == null) initStructureSG21(); return mStructureSG21; }
    static void initStructureSG21 ()
    {
        mStructureSG21 = new Group ("SG21","", "",
                new Particle[]{
                        new Particle("DIM", getStructureDIM(), 1, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG22 = null;
    static StructureItem getStructureSG22() {  if (mStructureSG22 == null) initStructureSG22(); return mStructureSG22; }
    static void initStructureSG22 ()
    {
        mStructureSG22 = new Group ("SG22","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG23 = null;
    static StructureItem getStructureSG23() {  if (mStructureSG23 == null) initStructureSG23(); return mStructureSG23; }
    static void initStructureSG23 ()
    {
        mStructureSG23 = new Group ("SG23","", "",
                new Particle[]{
                        new Particle("PCI", getStructurePCI(), 1, 1, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 1, 1, false, new String[]{}),				new Particle("GIN", getStructureGIN(), 0, 10, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG24 = null;
    static StructureItem getStructureSG24() {  if (mStructureSG24 == null) initStructureSG24(); return mStructureSG24; }
    static void initStructureSG24 ()
    {
        mStructureSG24 = new Group ("SG24","", "",
                new Particle[]{
                        new Particle("DOC", getStructureDOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG25 = null;
    static StructureItem getStructureSG25() {  if (mStructureSG25 == null) initStructureSG25(); return mStructureSG25; }
    static void initStructureSG25 ()
    {
        mStructureSG25 = new Group ("SG25","", "",
                new Particle[]{
                        new Particle("GOR", getStructureGOR(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),				new Particle("SEL", getStructureSEL(), 0, 9, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 9, 1, false, new String[]{}),				new Particle("SG26", getStructureSG26(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG26 = null;
    static StructureItem getStructureSG26() {  if (mStructureSG26 == null) initStructureSG26(); return mStructureSG26; }
    static void initStructureSG26 ()
    {
        mStructureSG26 = new Group ("SG26","", "",
                new Particle[]{
                        new Particle("DOC", getStructureDOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG27 = null;
    static StructureItem getStructureSG27() {  if (mStructureSG27 == null) initStructureSG27(); return mStructureSG27; }
    static void initStructureSG27 ()
    {
        mStructureSG27 = new Group ("SG27","", "",
                new Particle[]{
                        new Particle("TPL", getStructureTPL(), 1, 1, 1, false, new String[]{}),				new Particle("SG28", getStructureSG28(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG28 = null;
    static StructureItem getStructureSG28() {  if (mStructureSG28 == null) initStructureSG28(); return mStructureSG28; }
    static void initStructureSG28 ()
    {
        mStructureSG28 = new Group ("SG28","", "",
                new Particle[]{
                        new Particle("MEA", getStructureMEA(), 1, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG29 = null;
    static StructureItem getStructureSG29() {  if (mStructureSG29 == null) initStructureSG29(); return mStructureSG29; }
    static void initStructureSG29 ()
    {
        mStructureSG29 = new Group ("SG29","", "",
                new Particle[]{
                        new Particle("SGP", getStructureSGP(), 1, 1, 1, false, new String[]{}),				new Particle("SG30", getStructureSG30(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG3 = null;
    static StructureItem getStructureSG3() {  if (mStructureSG3 == null) initStructureSG3(); return mStructureSG3; }
    static void initStructureSG3 ()
    {
        mStructureSG3 = new Group ("SG3","", "",
                new Particle[]{
                        new Particle("RFF", getStructureRFF(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG30 = null;
    static StructureItem getStructureSG30() {  if (mStructureSG30 == null) initStructureSG30(); return mStructureSG30; }
    static void initStructureSG30 ()
    {
        mStructureSG30 = new Group ("SG30","", "",
                new Particle[]{
                        new Particle("MEA", getStructureMEA(), 1, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG31 = null;
    static StructureItem getStructureSG31() {  if (mStructureSG31 == null) initStructureSG31(); return mStructureSG31; }
    static void initStructureSG31 ()
    {
        mStructureSG31 = new Group ("SG31","", "",
                new Particle[]{
                        new Particle("TCC", getStructureTCC(), 1, 1, 1, false, new String[]{}),				new Particle("CUX", getStructureCUX(), 0, 1, 1, false, new String[]{}),				new Particle("PRI", getStructurePRI(), 0, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),				new Particle("PCD", getStructurePCD(), 0, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 9, 1, false, new String[]{}),				new Particle("QTY", getStructureQTY(), 0, 9, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG32 = null;
    static StructureItem getStructureSG32() {  if (mStructureSG32 == null) initStructureSG32(); return mStructureSG32; }
    static void initStructureSG32 ()
    {
        mStructureSG32 = new Group ("SG32","", "",
                new Particle[]{
                        new Particle("DGS", getStructureDGS(), 1, 1, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 99, 1, false, new String[]{}),				new Particle("SG33", getStructureSG33(), 0, 9, 1, false, new String[]{}),				new Particle("SG34", getStructureSG34(), 0, 9, 1, false, new String[]{}),				new Particle("SG35", getStructureSG35(), 0, 999, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG33 = null;
    static StructureItem getStructureSG33() {  if (mStructureSG33 == null) initStructureSG33(); return mStructureSG33; }
    static void initStructureSG33 ()
    {
        mStructureSG33 = new Group ("SG33","", "",
                new Particle[]{
                        new Particle("CTA", getStructureCTA(), 1, 1, 1, false, new String[]{}),				new Particle("COM", getStructureCOM(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG34 = null;
    static StructureItem getStructureSG34() {  if (mStructureSG34 == null) initStructureSG34(); return mStructureSG34; }
    static void initStructureSG34 ()
    {
        mStructureSG34 = new Group ("SG34","", "",
                new Particle[]{
                        new Particle("MEA", getStructureMEA(), 1, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG35 = null;
    static StructureItem getStructureSG35() {  if (mStructureSG35 == null) initStructureSG35(); return mStructureSG35; }
    static void initStructureSG35 ()
    {
        mStructureSG35 = new Group ("SG35","", "",
                new Particle[]{
                        new Particle("SGP", getStructureSGP(), 1, 1, 1, false, new String[]{}),				new Particle("SG36", getStructureSG36(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG36 = null;
    static StructureItem getStructureSG36() {  if (mStructureSG36 == null) initStructureSG36(); return mStructureSG36; }
    static void initStructureSG36 ()
    {
        mStructureSG36 = new Group ("SG36","", "",
                new Particle[]{
                        new Particle("MEA", getStructureMEA(), 1, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG37 = null;
    static StructureItem getStructureSG37() {  if (mStructureSG37 == null) initStructureSG37(); return mStructureSG37; }
    static void initStructureSG37 ()
    {
        mStructureSG37 = new Group ("SG37","", "",
                new Particle[]{
                        new Particle("EQD", getStructureEQD(), 1, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),				new Particle("TMD", getStructureTMD(), 0, 1, 1, false, new String[]{}),				new Particle("MEA", getStructureMEA(), 0, 9, 1, false, new String[]{}),				new Particle("DIM", getStructureDIM(), 0, 9, 1, false, new String[]{}),				new Particle("SEL", getStructureSEL(), 0, 99, 1, false, new String[]{}),				new Particle("TPL", getStructureTPL(), 0, 9, 1, false, new String[]{}),				new Particle("HAN", getStructureHAN(), 0, 1, 1, false, new String[]{}),				new Particle("TMP", getStructureTMP(), 0, 1, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 9, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 9, 1, false, new String[]{}),				new Particle("SG38", getStructureSG38(), 0, 99, 1, false, new String[]{}),				new Particle("SG39", getStructureSG39(), 0, 9, 1, false, new String[]{}),				new Particle("SG41", getStructureSG41(), 0, 99, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG38 = null;
    static StructureItem getStructureSG38() {  if (mStructureSG38 == null) initStructureSG38(); return mStructureSG38; }
    static void initStructureSG38 ()
    {
        mStructureSG38 = new Group ("SG38","", "",
                new Particle[]{
                        new Particle("TCC", getStructureTCC(), 1, 1, 1, false, new String[]{}),				new Particle("CUX", getStructureCUX(), 0, 1, 1, false, new String[]{}),				new Particle("PRI", getStructurePRI(), 0, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),				new Particle("PCD", getStructurePCD(), 0, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 9, 1, false, new String[]{}),				new Particle("QTY", getStructureQTY(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG39 = null;
    static StructureItem getStructureSG39() {  if (mStructureSG39 == null) initStructureSG39(); return mStructureSG39; }
    static void initStructureSG39 ()
    {
        mStructureSG39 = new Group ("SG39","", "",
                new Particle[]{
                        new Particle("NAD", getStructureNAD(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 1, 1, false, new String[]{}),				new Particle("SG40", getStructureSG40(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG4 = null;
    static StructureItem getStructureSG4() {  if (mStructureSG4 == null) initStructureSG4(); return mStructureSG4; }
    static void initStructureSG4 ()
    {
        mStructureSG4 = new Group ("SG4","", "",
                new Particle[]{
                        new Particle("GOR", getStructureGOR(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),				new Particle("SEL", getStructureSEL(), 0, 9, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 9, 1, false, new String[]{}),				new Particle("SG5", getStructureSG5(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG40 = null;
    static StructureItem getStructureSG40() {  if (mStructureSG40 == null) initStructureSG40(); return mStructureSG40; }
    static void initStructureSG40 ()
    {
        mStructureSG40 = new Group ("SG40","", "",
                new Particle[]{
                        new Particle("CTA", getStructureCTA(), 1, 1, 1, false, new String[]{}),				new Particle("COM", getStructureCOM(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG41 = null;
    static StructureItem getStructureSG41() {  if (mStructureSG41 == null) initStructureSG41(); return mStructureSG41; }
    static void initStructureSG41 ()
    {
        mStructureSG41 = new Group ("SG41","", "",
                new Particle[]{
                        new Particle("EQA", getStructureEQA(), 1, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG5 = null;
    static StructureItem getStructureSG5() {  if (mStructureSG5 == null) initStructureSG5(); return mStructureSG5; }
    static void initStructureSG5 ()
    {
        mStructureSG5 = new Group ("SG5","", "",
                new Particle[]{
                        new Particle("DOC", getStructureDOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 1, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG6 = null;
    static StructureItem getStructureSG6() {  if (mStructureSG6 == null) initStructureSG6(); return mStructureSG6; }
    static void initStructureSG6 ()
    {
        mStructureSG6 = new Group ("SG6","", "",
                new Particle[]{
                        new Particle("CPI", getStructureCPI(), 1, 1, 1, false, new String[]{}),				new Particle("RFF", getStructureRFF(), 0, 99, 1, false, new String[]{}),				new Particle("CUX", getStructureCUX(), 0, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 9, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG7 = null;
    static StructureItem getStructureSG7() {  if (mStructureSG7 == null) initStructureSG7(); return mStructureSG7; }
    static void initStructureSG7 ()
    {
        mStructureSG7 = new Group ("SG7","", "",
                new Particle[]{
                        new Particle("TCC", getStructureTCC(), 1, 1, 1, false, new String[]{}),				new Particle("LOC", getStructureLOC(), 0, 1, 1, false, new String[]{}),				new Particle("FTX", getStructureFTX(), 0, 1, 1, false, new String[]{}),				new Particle("CUX", getStructureCUX(), 0, 1, 1, false, new String[]{}),				new Particle("PRI", getStructurePRI(), 0, 1, 1, false, new String[]{}),				new Particle("EQN", getStructureEQN(), 0, 1, 1, false, new String[]{}),				new Particle("PCD", getStructurePCD(), 0, 1, 1, false, new String[]{}),				new Particle("MOA", getStructureMOA(), 0, 9, 1, false, new String[]{}),				new Particle("QTY", getStructureQTY(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG8 = null;
    static StructureItem getStructureSG8() {  if (mStructureSG8 == null) initStructureSG8(); return mStructureSG8; }
    static void initStructureSG8 ()
    {
        mStructureSG8 = new Group ("SG8","", "",
                new Particle[]{
                        new Particle("TDT", getStructureTDT(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),				new Particle("TSR", getStructureTSR(), 0, 9, 1, false, new String[]{}),				new Particle("SG9", getStructureSG9(), 0, 99, 1, false, new String[]{}),				new Particle("SG10", getStructureSG10(), 0, 9, 1, false, new String[]{}),			});
    }

    static StructureItem mStructureSG9 = null;
    static StructureItem getStructureSG9() {  if (mStructureSG9 == null) initStructureSG9(); return mStructureSG9; }
    static void initStructureSG9 ()
    {
        mStructureSG9 = new Group ("SG9","", "",
                new Particle[]{
                        new Particle("LOC", getStructureLOC(), 1, 1, 1, false, new String[]{}),				new Particle("DTM", getStructureDTM(), 0, 9, 1, false, new String[]{}),			});
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
        String[] arStandardSegments = new String[] { "ADR","AGR","AJT","ALC","ALI","APR","ARD","ARR","ASI","ATT","AUT","BGM","BII","BUS","CAV","CCD","CCI","CDI","CDS","CDV","CED","CIN","CLI","CMP","CNI","CNT","COD","COM","COT","CPI","CPS","CPT","CST","CTA","CUX","DAM","DFN","DGS","DII","DIM","DLI","DLM","DMS","DOC","DRD","DSG","DSI","DTM","EDT","EFI","ELM","ELU","ELV","EMP","EQA","EQD","EQN","ERC","ERP","EVT","FCA","FII","FNS","FNT","FOR","FSQ","FTX","GDS","GID","GIN","GIR","GIS","GOR","GRU","HAN","HYN","ICD","IDE","IHC","IMD","IND","INP","INV","IRQ","LAN","LIN","LOC","MEA","MEM","MKS","MOA","MSG","NAD","NAT","PAC","PAI","PAS","PAT","PCC","PCD","PCI","PDI","PGI","PIA","PNA","POC","PRC","PRI","PSD","PTY","QRS","QTY","QUA","QVR","RCS","REL","RFF","RJL","RNG","ROD","RSL","RTE","SAL","SCC","SCD","SEG","SEL","SEQ","SFI","SGP","SGU","SPR","SPS","STA","STC","STG","STS","TAX","TCC","TDT","TEM","TMD","TMP","TOD","TPL","TRU","TSR","UCD","UCF","UCI","UCM","UCS","UGH","UGT","UIB","UIH","UIR","UIT","UIZ","UNA","UNB","UNE","UNG","UNH","UNO","UNP","UNS","UNT","UNZ","USA","USB","USC","USD","USE","USF","USH","USL","USR","UST","USU","USX","USY","VLI" };
        StandardSegments.addAll( java.util.Arrays.asList( arStandardSegments) );

        String[] arIFTMINSegments = new String[] { "BGM","CNT","COM","CPI","CTA","CUX","DGS","DIM","DOC","DTM","EQA","EQD","EQN","FTX","GDS","GID","GIN","GOR","HAN","LOC","MEA","MOA","NAD","PCD","PCI","PIA","PRI","QTY","RFF","RNG","SEL","SGP","TCC","TDT","TMD","TMP","TOD","TPL","TSR","UNH","UNT" };
        mMessages.put( "IFTMIN", new Message( "IFTMIN", new Particle("Message_IFTMIN", getStructureMessage_IFTMIN(), 1,1,1, false, new String[]{}), new java.util.HashSet<String>( java.util.Arrays.asList( arIFTMINSegments) ), 0, 0, 0 ) );
    }

    public IFTMIND99AEnvelope()
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
        super.setStructureName("IFTMIN");

        super.mSettings = new EDIFactSettings();
        // EDIFact specific settings:

        ((EDIFactSettings)super.mSettings).setSyntaxLevel('A');

        ((EDIFactSettings)super.mSettings).setSyntaxVersionNumber(4);

        ((EDIFactSettings)super.mSettings).setControllingAgency("UNO");

        ((EDIFactSettings)super.mSettings).setWriteUNA(true);

        // general settings:
        super.mSettings.setMessageType("IFTMIN");
        super.mSettings.setLineEnd(0);
        super.mSettings.setAutoCompleteData(true);
        super.mSettings.setTerminateSegmentsWithLinefeed(true);

        super.mSettings.setVersion("D");

        super.mSettings.setRelease("99A");

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