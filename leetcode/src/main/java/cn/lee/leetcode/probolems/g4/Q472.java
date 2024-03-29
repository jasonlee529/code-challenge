package cn.lee.leetcode.probolems.g4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

/**
 * @Title: Q472
 * @Description: https://leetcode-cn.com/problems/concatenated-words/
 * @author: libo
 * @date: 2021/12/28 9:54
 * @Version: 1.0
 */
@Slf4j
public class Q472 {
	Trie trie = new Trie();

	public List<String> findAllConcatenatedWordsInADict(String[] words) {
		List<String> ans = new ArrayList<String>();
		Arrays.sort(words, (a, b) -> a.length() - b.length());
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (word.length() == 0) {
				continue;
			}
			if (dfs(word, 0)) {
				ans.add(word);
			} else {
				insert(word);
			}
		}
		return ans;
	}

	public boolean dfs(String word, int start) {
		if (word.length() == start) {
			return true;
		}
		Trie node = trie;
		for (int i = start; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			node = node.children[index];
			if (node == null) {
				return false;
			}
			if (node.isEnd) {
				if (dfs(word, i + 1)) {
					return true;
				}
			}
		}
		return false;
	}

	public void insert(String word) {
		Trie node = trie;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			int index = ch - 'a';
			if (node.children[index] == null) {
				node.children[index] = new Trie();
			}
			node = node.children[index];
		}
		node.isEnd = true;
	}


	public List<String> findAllConcatenatedWordsInADict2(String[] words) {
		Arrays.sort(words);
		Set<String> res = new LinkedHashSet<>();
		Stack<String> path = new Stack<String>();
		int[] pos = new int[words.length];
		for (int i = 0; i < words.length; i++) {
			pos[i] = 1;
			dfs(words[i], words, pos, path, res);
			pos[i] = 0;
			path = new Stack<>();
		}
		return new ArrayList<>(res);
	}

	private void dfs(String target, String[] words, int[] pos, Stack<String> path, Set<String> res) {
		String join = join(path);
		if (words.length <= 1) {
			return;
		}
		if (target.equalsIgnoreCase(join)) {
			res.add(target);
			return;
		}
		if (join.length() >= target.length() || !target.startsWith(join)) {
			return;
		}

		for (int i = 0; i < words.length; i++) {
			if (pos[i] == 1 || "".equalsIgnoreCase(words[i])) {
				continue;
			}
			path.push(words[i]);
			dfs(target, words, pos, path, res);
			path.pop();
		}

	}

	private String join(Stack<String> path) {
		StringBuilder sb = new StringBuilder();
		for (String s : path) {
			sb.append(s);
		}
		return sb.toString();
	}

	@Test
	public void test1() {
		Assert.assertArrayEquals(new String[]{"catsdogcats", "dogcatsdog", "ratcatdogcat"}, findAllConcatenatedWordsInADict(
				new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"}).toArray(new String[]{}));
	}

	@Test
	public void test2() {
		Assert.assertArrayEquals(new String[]{"catdog"}, findAllConcatenatedWordsInADict(
				new String[]{"cat", "dog", "catdog"}).toArray(new String[]{}));
	}

	@Test
	public void test3() {
		Assert.assertArrayEquals(new String[]{}, findAllConcatenatedWordsInADict(
				new String[]{""}).toArray(new String[]{}));
	}

	@Test
	public void test4() {
		Assert.assertArrayEquals(new String[]{}, findAllConcatenatedWordsInADict(
				new String[]{"rfkqyuqfjkx",
						"",
						"vnrtysfrzrmzl",
						"gfve",
						"qfpd",
						"lqdqrrcrwdnxeuo",
						"q",
						"klaitgdphcspij",
						"hbsfyfv",
						"adzpbfudkklrw",
						"aozmixr",
						"ife",
						"feclhbvfuk",
						"yeqfqojwtw",
						"sileeztxwjl",
						"ngbqqmbxqcqp",
						"khhqr",
						"dwfcayssyoqc",
						"omwufbdfxu",
						"zhift",
						"kczvhsybloet",
						"crfhpxprbsshsjxd",
						"ilebxwbcto",
						"yaxzfbjbkrxi",
						"imqpzwmshlpj",
						"ta",
						"hbuxhwadlpto",
						"eziwkmg",
						"ovqzgdixrpddzp",
						"c",
						"wnqwqecyjyib",
						"jy",
						"mjfqwltvzk",
						"tpvo",
						"phckcyufdqml",
						"lim",
						"lfz",
						"tgygdt",
						"nhcvpf",
						"fbrpzlk",
						"shwywshtdgmb",
						"bkkxcvg",
						"monmwvytby",
						"nuqhmfj",
						"qtg",
						"cwkuzyamnerp",
						"fmwevhwlezo",
						"ye",
						"hbrcewjxvcezi",
						"tiq",
						"tfsrptug",
						"iznorvonzjfea",
						"gama",
						"apwlmbzit",
						"s",
						"hzkosvn",
						"nberblt",
						"kggdgpljfisylt",
						"mf",
						"h",
						"bljvkypcflsaqe",
						"cijcyrgmqirz",
						"iaxakholawoydvch",
						"e",
						"gttxwpuk",
						"jf",
						"xbrtspfttota",
						"sngqvoijxuv",
						"bztvaal",
						"zxbshnrvbykjql",
						"zz",
						"mlvyoshiktodnsjj",
						"qplci",
						"lzqrxl",
						"qxru",
						"ygjtyzleizme",
						"inx",
						"lwhhjwsl",
						"endjvxjyghrveu",
						"phknqtsdtwxcktmw",
						"wsdthzmlmbhjkm",
						"u",
						"pbqurqfxgqlojmws",
						"mowsjvpvhznbsi",
						"hdkbdxqg",
						"ge",
						"pzchrgef",
						"ukmcowoe",
						"nwhpiid",
						"xdnnl",
						"n",
						"yjyssbsoc",
						"cdzcuunkrf",
						"uvouaghhcyvmlk",
						"aajpfpyljt",
						"jpyntsefxi",
						"wjute",
						"y",
						"pbcnmhf",
						"qmmidmvkn",
						"xmywegmtuno",
						"vuzygv",
						"uxtrdsdfzfssmel",
						"odjgdgzfmrazvnd",
						"a",
						"rdkugsbdpawxi",
						"ivd",
						"bbqeonycaegxfj",
						"lrfkraoheucsvpi",
						"eqrswgkaaaohxx",
						"hqjtkqaqh",
						"berbpmglbjipnuj",
						"wogwczlkyrde",
						"aqufowbig",
						"snjniegvdvotu",
						"ocedkt",
						"bbufnxorixibbd",
						"rzuqsyr",
						"qghoy",
						"evcuanuujszitaoa",
						"wsx",
						"glafbwzdd",
						"znrvjqeyqi",
						"npitruijvyllsi",
						"objltu",
						"ryp",
						"nvybsfrxtlfmp",
						"id",
						"zoolzslgd",
						"owijatklvjzscizr",
						"upmsoxftumyxifyu",
						"xucubv",
						"fctkqlroq",
						"zjv",
						"wzi",
						"ppvs",
						"mflvioemycnphfjt",
						"nwedtubynsb",
						"repgcx",
						"gsfomhvpmy",
						"kdohe",
						"tyycsibbeaxn",
						"wjkfvabn",
						"llkmagl",
						"thkglauzgkeuly",
						"paeurdvexqlw",
						"akdt",
						"ihmfrj",
						"janxk",
						"rqdll",
						"cyhbsuxnlftmjc",
						"yybwsjmajbwtuhkk",
						"ovytgaufpjl",
						"iwbnzhybsx",
						"mumbh",
						"jqmdabmyu",
						"br",
						"lwstjkoxbczkj",
						"vhsgzvwiixxaob",
						"fso",
						"qnebmfl",
						"ooetjiz",
						"lq",
						"msxphqdgz",
						"mqhoggvrvjqrp",
						"xbhkkfg",
						"zxjegsyovdrmw",
						"jav",
						"mshoj",
						"ax",
						"biztkfomz",
						"hujdmcyxdqteqja",
						"gqgsomonv",
						"reqqzzpw",
						"lihdnvud",
						"lznfhbaokxvce",
						"fhxbldylqqewdnj",
						"rlbskqgfvn",
						"lfvobeyolyy",
						"v",
						"iwh",
						"fpbuiujlolnjl",
						"gvwxljbo",
						"ypaotdzjxxrsc",
						"mwrvel",
						"umzpnoiei",
						"ogwilaswn",
						"yw",
						"egdgye",
						"hsrznlzrf",
						"mwdgxaigmxpy",
						"yaqgault",
						"dtlg",
						"cyvfiykmkllf",
						"zxqyhvizqmamj",
						"lvvgoifltzywueyp",
						"abinmy",
						"ppzaecvmx",
						"qsmzc",
						"iddymnl",
						"uskihek",
						"evxtehxtbthq",
						"jvtfzddlgch",
						"czohpyewf",
						"ufzazyxtqxcu",
						"brxpfymuvfvs",
						"xrrcfuusicc",
						"aqhlswbzievij",
						"rv",
						"udvmara",
						"upityz",
						"fecd",
						"suxteeitxtg",
						"dfuydrtbfypbn",
						"cypqodxr",
						"wikfuxwjht",
						"jrliuaifpp",
						"vkmxys",
						"wvpfyfpkvgthq",
						"rmajxis",
						"jncxgviyu",
						"av",
						"nmhskodmidaj",
						"lkfrimprrhen",
						"uip",
						"hstyopbvuiqc",
						"p",
						"vwduwmjpblqo",
						"fnxwgqtvwztje",
						"xwnbcuggl",
						"iehimvoymyjasin",
						"spsqiu",
						"flhyfac",
						"mqrbq",
						"pstsxhplrrmbeddv",
						"hnegtuxx",
						"alsyxezjwtlwmxv",
						"jtxytykkcku",
						"bhhlovgcx",
						"xhhivxnutkx",
						"had",
						"aysulvk",
						"m",
						"anhsyxli",
						"jdkgfc",
						"potn",
						"lcibpxkidmwexp",
						"gwoxjicdkv",
						"tltienw",
						"ngiutnuqbzi",
						"o",
						"tzlyb",
						"vumnwehj",
						"os",
						"np",
						"lhv",
						"uzvgyeette",
						"ipfvr",
						"lpprjjalchhhcmh",
						"k",
						"pciulccqssaqgd",
						"tp",
						"dmzdzveslyjad",
						"wtsbhgkd",
						"eouxbldsxzm",
						"vhtonlampljgzyve",
						"xhnlcrldtfthul",
						"xhflc",
						"upgei",
						"rlaks",
						"yfqvnvtnqspyjbxr",
						"phouoyhvls",
						"voibuvbhhjcdflvl",
						"rgorfbjrofokggaf",
						"dqhqats",
						"zchpicyuawpovm",
						"yzwfor",
						"koat",
						"pybf",
						"fhdzsbiyjld",
						"gznfnqydisn",
						"xz",
						"po",
						"tcjup",
						"wygsnxk",
						"kqlima",
						"fgxnuohrnhg",
						"publurhztntgmimc",
						"zuufzphd",
						"iucrmmmjqtcey",
						"wnnbq",
						"rghzyz",
						"ukjqsjbmp",
						"mdtrgv",
						"vyeikgjdnml",
						"kxwldnmi",
						"apzuhsbssaxj",
						"tkbkoljyodlipof",
						"nkq",
						"ktwtj",
						"vgmkgjwle",
						"t",
						"agylw",
						"vomtuy",
						"jbtvitkqn",
						"vtdxwrclpspcn",
						"rdrls",
						"yxfeoh",
						"upj",
						"myctacn",
						"fdnor",
						"ahqghzhoqprgkym",
						"phiuvdv",
						"jp",
						"fdgpouzjwbq",
						"hqoyefmugjvewhxu",
						"qfzwuwe",
						"fnsbijkeepyxry",
						"oja",
						"qthkcij",
						"zpmqfbmnr",
						"ybaibmzonzqlnmd",
						"svo",
						"gjftyfehik",
						"jfrfgznuaytvaegm",
						"aljhrx",
						"odjq",
						"ogwaxrssjxgvnka",
						"zaqswwofedxj",
						"lugpktauixp",
						"dc",
						"odknlbvxrs",
						"jeobu",
						"vqythyvzxbcgrlbg",
						"hwc",
						"erpbaxq",
						"ujxcxck",
						"rrklkb",
						"wlrwyuy",
						"zmg",
						"yyhga",
						"xwdbycdu",
						"htedgvsrhchox",
						"wr",
						"suhesetv",
						"jonqwhkwezjvjgg",
						"sqqyrxtjkcalswq",
						"hvyimhe",
						"pjzdkmoue",
						"zbphmgoxq",
						"lbdlcumdgixjbcq",
						"ztzdjqmadthtdmv",
						"qcagsyqggcf",
						"if",
						"jpjxcjyi",
						"chyicqibxdgkqtg",
						"iwpdklhum",
						"wljmg",
						"micmun",
						"npdbamofynykqv",
						"ijsnfkpfy",
						"lmq",
						"oyjmeqvhcrvgm",
						"mqopusqktdthpvz",
						"fz",
						"r",
						"qbsqtipq",
						"nxtsnason",
						"xbpipyhh",
						"topsuqomfjrd",
						"islif",
						"gbndakaq",
						"bwnkxnwpzeoohlx",
						"hrtbfnq",
						"fguvomeepxoffg",
						"mat",
						"dzfpfnwbfuj",
						"onlvy",
						"cwcchvsasdylb",
						"rxfcztzqopdi",
						"ybrhodjn",
						"oqkijy",
						"ncvrjo",
						"dphbfaal",
						"xgtpdtkz",
						"sebevsopjvciwljf",
						"rcumyacqdapwczen",
						"mabkapuoud",
						"pbozezeygljfftvy",
						"bvazmzbndl",
						"vl",
						"qiaixdtbhqvlzd",
						"ffjfb",
						"svthrfmkoxbho",
						"cvet",
						"ucgqyvopafyttrh",
						"lbgihet",
						"naiqyufxffdw",
						"vruh",
						"uz",
						"ukffmudygjavem",
						"dccamymhp",
						"wofwgjkykm",
						"fbuujzxhln",
						"kmm",
						"lzandlltowjpwsal",
						"fapfvrmezbsjxs",
						"wiw",
						"sc",
						"soqlh",
						"hzaplclkwl",
						"gcdqbcdwbwa",
						"gadgt",
						"pgowefka",
						"juffuguqepwnfh",
						"nbuinl",
						"cpdxf",
						"sox",
						"fq",
						"lfnrhgsxkhx",
						"xrcorfygjxpi",
						"mwtqjwbhgh",
						"loc",
						"fkglorkkvx",
						"nlzdhucvayrz",
						"azefobxutitrf",
						"rlrstkcbtikklmh",
						"ggk",
						"sbphcejuylh",
						"nraoenhd",
						"zngyodiqlchxyycx",
						"rrbhfwohfv",
						"krzolrglgn",
						"cpjesdzy",
						"yoifoyg",
						"hqqevqjugi",
						"ahmv",
						"xgaujnyclcjq",
						"evhyfnlohavrj",
						"byyvhgh",
						"hyw",
						"kedhvwy",
						"ysljsqminajfipds",
						"rglnpxfqwu",
						"cibpynkxg",
						"su",
						"mbntqrlwyampdg",
						"nig",
						"ldhlhqdyjcfhu",
						"jfymrbafmyoc",
						"tyjmnhlfnrtz",
						"dlazixtlxyvm",
						"fbiguhsfuqo",
						"rhymsno",
						"rkbdlchs",
						"ocbbwwd",
						"astaiamnepwkya",
						"mplirup",
						"edkxjq",
						"g",
						"exlwulswtvot",
						"tlnc",
						"vnrrzerz",
						"ygeraoozbtt",
						"yyifkin",
						"eo",
						"ua",
						"qgztvqdolf",
						"rlzddjzcshvd",
						"khxkdxflwxme",
						"kk",
						"zylbhoaac",
						"cw",
						"iizic",
						"gcdxstpz",
						"kjwdqeg",
						"earjrncmmkdel",
						"kbesuhquepj",
						"nrzbllldgdmyrpgl",
						"hllwnqozf",
						"djpchowhwevbqvjj",
						"zsmhylnjpktb",
						"pxnktxkm",
						"fxwiaqqb",
						"qjwufmwresfsfaok",
						"aa",
						"d",
						"iobioqm",
						"svjgzk",
						"khbzp",
						"euexyudhrioi",
						"yqsj",
						"ngrwqpoh",
						"rwuvd",
						"eruffmlg",
						"bxzovyew",
						"faz",
						"pmvfvyguqdi",
						"jlxnoixsy",
						"hyfrdngjf",
						"ly",
						"eibcapetpmeaid",
						"tpnwwiif",
						"pfgsp",
						"kvhhwkzvtvlhhb",
						"pjxurgqbtldims",
						"rncplkeweoirje",
						"akyprzzphew",
						"wyvfpjyglzrmhfqp",
						"ubheeqt",
						"rmbxlcmn",
						"taqakgim",
						"apsbu",
						"khwnykughmwrlk",
						"vtdlzwpbhcsbvjno",
						"tffmjggrmyil",
						"schgwrrzt",
						"mvndmua",
						"nlwpw",
						"glvbtkegzjs",
						"piwllpgnlpcnezqs",
						"xkelind",
						"urtxsezrwz",
						"zechoc",
						"vfaimxrqnyiq",
						"ybugjsblhzfravzn",
						"btgcpqwovwp",
						"zgxgodlhmix",
						"sfzdknoxzassc",
						"wgzvqkxuqrsqxs",
						"dwneyqisozq",
						"fg",
						"vhfsf",
						"uspujvqhydw",
						"eadosqafyxbmzgr",
						"tyff",
						"blolplosqnfcwx",
						"uwkl",
						"puenodlvotb",
						"iizudxqjvfnky",
						"cjcywjkfvukvveq",
						"jrxd",
						"igwb",
						"dftdyelydzyummmt",
						"uvfmaicednym",
						"oai",
						"higfkfavgeemcgo",
						"naefganqo",
						"iqebfibigljbc",
						"ulicojzjfrc",
						"igxprunj",
						"cymbrl",
						"fqmwciqtynca",
						"zjyagi",
						"mzuejrttefhdwqc",
						"zyiurxvf",
						"wrjxffzbjexsh",
						"wrxw",
						"mhrbdxjwi",
						"htknfa",
						"wfrvxqdkhbwwef",
						"vqsghhhutdget",
						"cwupzrts",
						"hbjnb",
						"wpccoa",
						"nx",
						"howbzhaoscgyk",
						"bilt",
						"wqqatye",
						"zceuuwg",
						"jxzon",
						"kkfj",
						"bwsezd",
						"ifdegsyjtswselk",
						"xweimxlnzoh",
						"tqthlftjblnpht",
						"ww",
						"ss",
						"b",
						"jmruuqscwjp",
						"nxbk",
						"wd",
						"cqkrtbxgzg",
						"xhppcjnq",
						"cfq",
						"tkkolzcfi",
						"wblxki",
						"ijeglxsvc",
						"kcqjjwcwuhvzydm",
						"gubqavlqffhrzz",
						"hiwxrgftittd",
						"caybc",
						"ncsyjlzlxyyklc",
						"poxcgnexmaajzuha",
						"dhaccuualacyl",
						"mtkewbprs",
						"oncggqvr",
						"sqqoffmwkplsgbrp",
						"ioajuppvqluhbdet",
						"dzwwzaelmo",
						"afumtqugec",
						"wglucmugwqi",
						"zveswrjevfz",
						"nxlbkak",
						"pzcejvxzeoybb",
						"fd",
						"vewj",
						"ivws",
						"zjhudtpqsfc",
						"zcmukotirrxx",
						"zksmx",
						"umofzhhowyftz",
						"zbotrokaxaryxlk",
						"ueolqk",
						"dxmzhoq",
						"zvu",
						"cjl",
						"esfmqgvxwfy",
						"npbep",
						"vbgjtbv",
						"poeugoqynkbfiv",
						"fewjjscjrei",
						"yqssxzsydgllfzmo",
						"urxkwcypctjkabi",
						"wqtldwhjouas",
						"tovdtkr",
						"onzgeyddkqwuhnim",
						"ffxviyvsktqrfa",
						"qujhd",
						"pvcz",
						"hiyjlkxmeplnrvxg",
						"hdykehkefp",
						"vepcxhozpjxtreyn",
						"liguhuxudbnh",
						"f",
						"ordxzm",
						"klgohcmmbukz",
						"yrmooliaobbnlap",
						"dutnbetocxylcey",
						"ywdsjegd",
						"cr",
						"blbxhjsgcuoxmqft",
						"ngzdc",
						"srfyjjumcbxole",
						"dazwzwtdjoyuqeqj",
						"xazjarqgfm",
						"fxyfqbeoktcc",
						"qrsjchxp",
						"iltaqzawhgu",
						"sgenjcfxr",
						"yfikp",
						"dvwhbyumthkiktb",
						"walsx",
						"jyajrkcvysicisab",
						"brdeumb",
						"tviihjwxdcz",
						"dnrrgmem",
						"ydgxlrjzucxyid",
						"cdvdpvjlagwmg",
						"ngnpxjkxims",
						"gvyhnchlimsxc",
						"w",
						"jtizpezjl",
						"qe",
						"rjzv",
						"vhnqvi",
						"qm",
						"iedzqswrsnfmnn",
						"lt",
						"utqfcqyrrwm",
						"wtelvsqrru",
						"fjwrhjcrtbcytn",
						"qmqxceuohpiffaq",
						"rmoybqjjgdyo",
						"pmxttqftypfexlv",
						"tg",
						"qa",
						"iqbqjlnpbf",
						"kgaynkddbzllecd",
						"tccvslp",
						"curkxfoimnw",
						"fvnyqkzlheruxr",
						"iiygnzfov",
						"coqs",
						"oa",
						"eiu",
						"vzemmxtklis",
						"lxu",
						"nrwsjaxzwmh",
						"tdayz",
						"oxbbemejgosgcynf",
						"ykbcn",
						"hesvnctfvdsp",
						"ku",
						"rjhykpadahbhj",
						"at",
						"sxlngbtxmqr",
						"wqrom",
						"qzyabzrco",
						"rbbyklndcqdj",
						"cnsmgmwmpbgjq",
						"krvnaf",
						"qrwfajnfahyqocdb",
						"fnlaozmff",
						"vmoymbmytjvfcgt",
						"cijyy",
						"jdgwjbztl",
						"swmalgbgpaplqgz",
						"hfl",
						"typttkrpfvx",
						"tkzpzrscwbx",
						"bwfqqvjcukjbsg",
						"nxqmxr",
						"x",
						"eyavnz",
						"il",
						"dhthp",
						"eyelg",
						"npsoqsw",
						"reogbmveofvusdsx",
						"jvdrjkhxkq",
						"qzjbrpljwuzpl",
						"czqeevvbvcwh",
						"vzuszqvhlmapty",
						"yu",
						"yldwwgezlqur",
						"vorxwgdtgjilgydq",
						"pknt",
						"bgihl",
						"ckorgrm",
						"ixylxjmlfv",
						"bpoaboylced",
						"zea",
						"igfagitkrext",
						"ipvqq",
						"dmoerc",
						"oqxbypihdv",
						"dtjrrkxro",
						"rexuhucxpi",
						"bvmuyarjwqpcoywa",
						"qwdmfpwvamisns",
						"bhopoqdsref",
						"tmnm",
						"cre",
						"ktrniqwoofoeenbz",
						"vlrfcsftapyujmw",
						"updqikocrdyex",
						"bcxw",
						"eaum",
						"oklsqebuzeziisw",
						"fzgyhvnwjcns",
						"dybjywyaodsyw",
						"lmu",
						"eocfru",
						"ztlbggsuzctoc",
						"ilfzpszgrgj",
						"imqypqo",
						"fump",
						"sjvmsbrcfwretbie",
						"oxpmplpcg",
						"wmqigymr",
						"qevdyd",
						"gmuyytguexnyc",
						"hwialkbjgzc",
						"lmg",
						"gijjy",
						"lplrsxznfkoklxlv",
						"xrbasbznvxas",
						"twn",
						"bhqultkyfq",
						"saeq",
						"xbuw",
						"zd",
						"kng",
						"uoay",
						"kfykd",
						"armuwp",
						"gtghfxf",
						"gpucqwbihemixqmy",
						"jedyedimaa",
						"pbdrx",
						"toxmxzimgfao",
						"zlteob",
						"adoshnx",
						"ufgmypupei",
						"rqyex",
						"ljhqsaneicvaerqx",
						"ng",
						"sid",
						"zagpiuiia",
						"re",
						"oadojxmvgqgdodw",
						"jszyeruwnupqgmy",
						"jxigaskpj",
						"zpsbhgokwtfcisj",
						"vep",
						"ebwrcpafxzhb",
						"gjykhz",
						"mfomgxjphcscuxj",
						"iwbdvusywqlsc",
						"opvrnx",
						"mkgiwfvqfkotpdz",
						"inpobubzbvstk",
						"vubuucilxyh",
						"bci",
						"dibmye",
						"rlcnvnuuqfvhw",
						"oorbyyiigppuft",
						"swpksfdxicemjbf",
						"goabwrqdoudf",
						"yjutkeqakoarru",
						"wuznnlyd",
						"vfelxvtggkkk",
						"mxlwbkbklbwfsvr",
						"advraqovan",
						"smkln",
						"jxxvzdjlpyurxpj",
						"ssebtpznwoytjefo",
						"dynaiukctgrzjx",
						"irzosjuncvh",
						"hcnhhrajahitn",
						"vwtifcoqepqyzwya",
						"kddxywvgqxo",
						"syxngevs",
						"batvzmziq",
						"mjewiyo",
						"pzsupxoflq",
						"byzhtvvpj",
						"cqnlvlzr",
						"akvmxzbaei",
						"mwo",
						"vg",
						"ekfkuajjogbxhjii",
						"isdbplotyak",
						"jvkmxhtmyznha",
						"lqjnqzrwrmgt",
						"mbbhfli",
						"bpeohsufree",
						"ajrcsfogh",
						"lucidbnlysamvy",
						"tutjdfnvhahxy",
						"urbrmmadea",
						"hghv",
						"acnjx",
						"athltizloasimp",
						"gu",
						"rjfozvgmdakdhao",
						"iephs",
						"uztnpqhdl",
						"rfuyp",
						"crcszmgplszwfn",
						"zihegt",
						"xbspa",
						"cjbmsamjyqqrasz",
						"ghzlgnfoas",
						"ljxl",
						"cnumquohlcgt",
						"jm",
						"mfccj",
						"hfedli",
						"vtpieworwhyiucs",
						"tdtuquartspkotm",
						"pnkeluekvelj",
						"ugrloq",
						"zljmwt",
						"fkyvqguqq",
						"tpjidglpxqfxv",
						"l",
						"tvvimvroz",
						"yy",
						"opwyfovdz",
						"pwlumocnyuoume",
						"vjqpzkcfc",
						"ihicd",
						"dtttiixlhpikbv",
						"goblttgvmndkqgg",
						"gwsibcqahmyyeagk",
						"prtvoju",
						"lcblwidhjpu",
						"kbu",
						"pey",
						"gkzrpc",
						"bqajopjjlfthe",
						"bc",
						"lqs",
						"zkndgojnjnxqsoqi",
						"zyesldujjlp",
						"drswybwlfyzph",
						"xzluwbtmoxokk",
						"bedrqfui",
						"opajzeahv",
						"lehdfnr",
						"mnlpimduzgmwszc",
						"velbhj",
						"miwdn",
						"wruqc",
						"kscfodjxg",
						"wcbm"}).toArray(new String[]{}));
	}

}

class Trie {
	Trie[] children;
	boolean isEnd;

	public Trie() {
		children = new Trie[26];
		isEnd = false;
	}
}