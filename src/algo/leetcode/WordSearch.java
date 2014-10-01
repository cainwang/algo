/**
 *
 */
package algo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Cain
 *
 */
public class WordSearch {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String[] inputs = {
                "elxllvxegzmvgnhrypvagxrgwktiqnyuavfnsfsbgewnrferubrcykjwveenrfhtamhvtzwafspzxvqtwkxwwgttkzgdenzhcgcvhyxosonrjgmhsjeo",
                "qxkcyqidehkipofwofmgtazfilocwuqotatstbvzkhhzvmxjrjrnlsutdixbdoqwqjolklkwstvpgsyzdropjikoriquygsqphcbuoxniucoodpruegg",
                "mrudzkzxsupjbrmxgjkofpetutnoztwmmrrndtmwncfqtsnbdaplrvglptbqpycdpwrspdqehyudsjevjwictpnkkpbznfdebwysbpwjnsmfcscnqnqk",
                "cdumuvojbtnepmxqdvbsopzskdfaqxkudhhxexhfqwkfkjxnezhuqgmamsbcrnxuwgsbdbgtxsaidxxiyfcplrpxlqccgzxchrdksmfpgfxkexudcysp",
                "phnaarfisckztqllcqckxcubzqebpyqgifjkwosqqeplucyysajreftfwzgnazvkgeufsovisnvpptnkwybagwgeyotypokwteblsywmlrbbnrljrmlx",
                "ltbjiujxjtvczwprvlfifhjsaubrjmpugsfqnopyjlcijrbgfgpkpacpvfhgtwczohrdxhbgudqfxroczdopdqeavliojkqarjdqshwomoujfinhnbws",
                "tatoobfxmxzfidwbkupwjlgqtvxgxvzqyuhmxollnltvqpyalowwbepvcmdzkeriaauyohjducbktzkhpjdrpsorhrstykbykxwbeigzmhlihwpwhupw",
                "pdoyxirvsuvfrsivcowqwiydgpbnmrlbwbbtkuqcomjfgrckgbaejzjrqkgcdrfctgxfcojqctvkkausbuymvhdmsjqxcwzxezchnmzrfxbrxvmapkmn",
                "srbmcrleplcukgdzscszbtraofafpmujdvxfnjmcwoygubhpgzojuhkkmkrexmnchlkuuwzqmxyibhxhioqcvcmindmmrbozoyvkwuciscrvlqcteuxa",
                "zlkmryyibmhqndcjzfutjnovdsokpomozyaqwyzxmipbnslnxhgguxbzpslegxsfxuytuztjhikvaxkzesgypjahdllllgticrexqxgzfqwiqghubpvq",
                "bxxeilsvtleveksuhatotswjygfzvasyxrficxdvijtmtniaodrhvnswtxvrappxhuhjtlhduarqnzsdfjmcxeyscwlcldbszjetwnwspoiepbiukuzj",
                "zxedtrfhuiburhpnulilbqqttypgsoptmvwhnbqhmuddbstygbjjtzcnzstsiknwgkgvnwczqgfuyysgbdqwfslemgyvrmtzwzujwyjoeqifoclrgdnl",
                "ybrkhqhycbzyatjysspyizfycrrkwhxuiofpeoogrpeujosdijbtjhtlalxwsutciarpohvgxcaisulcgovpvrcxezwyvpafprufzqlysngmkroqfkfd",
                "djchkyhfphkeafkbxxzrnfdxyrngdulgfnppowufdgkgnwhkvhbiogfpyuxdqkkvzbknygtdnfjadtnaaojqvqhvleydokzomldmsyrhfbhkuulwluoi",
                "mwfzcddtoejcpmojnfqsiafewqchmtrypwytcdmqhxuwmkizrytcaygxqlgceabvwboyedqnamlowtnoujqujytajacnafkyizxoepbgcnvygkoatgxf",
                "fqfqsjgsrqtzrsoxhpgjcbklnaljhkoobvetemovfjxwblwiccuffgssgddnqrbrmimtwcobllamywvbargfxyzdddttwwmjgbcddsgpegbeeyfernlo",
                "nlutqnomlbxsczvhubwakaeoakvsxgiltcejrswdvtxzvshpvdrhfvygftafbisvnyeeqcjoygntawkycbfhwdpeyplaadvnbbttgdhelxzmtjkxmrfk",
                "xwovozvocsdfwwzcbigphfbbqnacgfmdedbsewgjrjonhprlyzafediwsjyyqmeurfmwdufufvjnlcalbaqhfbdxkdxaqbxjgjfkgmglisavuagwcydh",
                "zjglmeoeflomwtycigosyqnvrvttvydvhjgupwyvhmjgijiqpykqpzliugdpegmmsvihriezvnhfwpxoqhefgrpcxstbzgptbxaugfvduckrujhkqlry",
                "cgcbyvczdusgttbbaweubqnvzufrfypjetkcrpcujwbcpeepakmddzycufubdlnhhzmyoqszmveezkvcwhfzheedjygnltwstiqjallngptizokxyrxh",
                "vbkhbswomujhfbqfmduvsndtenrceojcrvlsnjizdriitbofekcxafseujgbzrdsmqmzzvbcmjlfkbnpnponvgrrszsrqxkcnwcmtdrgoenbfaquqgin",
                "obegbxatumwkkawefpmvtzwaamvsudfjglrhirbffzpqbnwididyhazhowbjbguhslrcfujmtaewoaetkhtshsbwqdhrldzfqqixktkfuodkrhfboyvy",
                "tzwjcfdpicvyufwgyinsyqcpxjtnioldnjmropjwtexnjvvjdicbygtxsmlacydsirlyjuxcausjrnvuyzxyhqwzehbhhebrymqhhnljjdvatqwtptrw",
                "kpyqyzzggaxenpnwcyfneanzsjshdlgpbefzdhfjhfpuucszbamfcagvjycojkfmonmuurfbyvytxssysefvglqslugxfmjtbvpvpvypqwinpcohjtep",
                "huhuporucbpfyfapayfsxpfostvbpcqywysnomjspbxnizfkxmcwbhktdiwukpuinmwdahxpiufqtkaswepxmbtrjrntghettcywjvlurqmkapfytwyh",
                "xtyhklcruimqklmuixoaoamqprrlppsnitwsgalbjyrtldntadvqgijxbairpbgzwctccfdndwhozwjcafuipdfqdojurptptpryuxlztspvraztftbw",
                "xipawyxpqqgjhyhbxvcsprpguozbicyhlpjjngbfzhrghakgvmzlgotafvbpxbwiqfugovlneetmfdscstnyijapebebdamthibxdnkhrgvylobdhqdr",
                "zdgdhmhmmvfwdhtiwgpponozbrfkhkehommxzvjnqojvxfdvnvnbibclujxbubkiqzhpuqcngoievobijolrrnelxbptfzdvykkvaoigesmzgojpcwiw",
                "kohjqwcvyfqwpctrqbxxukwcyiscecaqrizjgdgekydbawssaqpwcoycwseavftopuxvydckbhmddgxfypbadacbsjdpqwdhrccrhgbknpntynywcczf",
                "ediymloeitlbwqsfwvqmlfhlshhujibnmjmavcffvsitiazhxptkuavnhfjtnlizuucpyhwuzenkgoredkoamkpvpyoejxeetgvspsoqydafsrjxdxxr",
                "jmnandfwclcytyskqgaqldvdwebaeatppiqcoxaqidqdbintqnjcqfhnliprlijatbehyezihqlkaydtnpxgwevjpmdawmcppgwpmyxwokgqkmjzdghz",
                "nckcqnenbgcqobfczeypohhavtcabjbomlsczwraewtszyxadxptgywdrydthehvqaaryrtdnmxoluoqsflaejevjhqroyoeaoxaiqdxdbmqxagrgtsm",
                "fyhofyfvywbamyaupguujgkgisaqlscsqmhxmovmkwmxvotmungdvsmekmwxgzqylxvxlsjwpxvmnoyiegnzybfinchtdxroupnihygyvbkirksxqizq",
                "jeaxiislfmbcdqkkoqjltvwkgqkyyjrkprjybbljpnlsfxfupqhildutweuwplgfepdgtqrkdedjbifsymalswfqdbmsmtxskcaftrqyvtjydoqddsox",
                "pvnuwzmkumdhqfmjxcisvrtaijdneukvrxpqydavrfcilorktbeqvxrdjwqnqciibxyzcawuiacvrvfkxjashtvsqnfgpnqqmqrorokbqmwhibrhmuzv",
                "nwndlumahesvvjmozwpqlnzvqrecndaabngmiuoryiptrbhtzylmlkjbdngqsgtttbhdvxxvfmpzpysozfdkrmovcunuciqxjzbgxaeemvdbtxruewhw",
                "lvtnrgjtrzqcztjytpehkikfhcamahilcbyvjkoajgdkcokvfpdpznugrusubcffdgcpqqpbzuobkyypnbgmrbvkvngzqogvujkmbcpaydblcacrdjgw",
                "kbjhqpiidpezyqnzudctgfgkhientkjfnupdmxorostmkgoflsasxgehqiumufrhainogbfuvyjfhzksrkmqsrxjztxuzodbxqpftwboxmuelgyetlxl",
                "cwwdqtzpkfsjxjorfrfeebkrkjwduvqyrpdhkdyuiqffzvyhnglrhwitfgwbbpzteccohblrtqzvoxcbdpsnlcgsjftmuuhazkoinbaiuzdiyfjcvdpi",
                "hxbscwfwtmwuyncnqewkfzuehfieizmswpkzorxheudejfszmomrpgvwmdawepobebassxbytgdeoxgansrcapboubnzsdazectzbvxxdabrzhrmblpc",
                "cqswtfxmjznpbgofdmchodyolsaodrqfhlddqbrbaetekhjovlxmqvadncsqukxdvbimezpgfikssvinifzzabeqewiahgfejosnpitxqgpibzymexng",
                "brwhqfhzlmdwcwjseerwkghofhalenrhgoowtvxgkbemxngdrzbehkuoruzyjrfrhuqcrnkdoosnbasuauahguwyqvwbodtvxjxrwhunvmaynvvprxwx",
                "ssviqtmexfawqzpojkbgyehnzccqzbpttnelgqqfxsenrtbaffjgjqtkuycvbrpuevgnlyukqyxjsamxfvdqlzahzccawrwcmepzcmjukiecjqcqnhhy",
                "ijfjojjkbgopmgrrsclclrhwhlowuvwdhdmvnyhqgvhsbyjtdxyoofmyqaukyrpfucchcjxiefaifmbijzyxgmvwnsjnjasfeupgfmojtprbdvlmwkjd",
                "whblbkaklsrpogwvvmfodyrgvdsspexnnyzolzawurnkylgtynjdnbklecdtiagvahjljjjfdxrbkzwkohoeiypocujlwsiwbsimdrriqljbkhnbpbfz",
                "buqgoztktbgvvohzibhymtzycnzrqetuajaoityeuhzqxirfjaexvfyyuzrnekhevhvecviwcjoarhhdklcftcfpczcillohujnwfxtjgjjzrrebejiz",
                "lornpvvahkjbvwyattmbcvdtohwvqfwevnrkjpmsbwtwsrzomlppiskzchwuosyjisvtjhlkdeiwyhkkubbdwmeyvaujuvucnpxywiiapqypakbuldzh",
                "rdfmfcxaxremickemsgbkeskouhcxijqorcttbvssceaeogsinwstofkkomjwxzkobgjcbbwdfyjvfcduyypofbztpipnicdlipqjqopynyvucbqcbht",
                "gjsbacqpmutacisoagfavfwrixhmyrfgczhcezsqulsyvkoxrtyozugjtpxtgdzkegnihfbdstcpeqmxmklngtwzltstytedbrnjyomskohohvnvgaio",
                "ueohziaacefdvsovjbnvrwlysyvaadoujedjnelriqwgkldtorqfnbgfzbfafwwqaazpgkiqcfwnsaigtzngavoaxvcerauucwjiiszlzxarzizuhobi",
                "krkhooniojctfndqfcdecdxdlyytnbdxungidtqrcumkiqcnufuwitcvuaqhbtgvimflhyflsrxahzqcgmaohcmbecihwqegckslixzcowfwwvacjatq",
                "fhujjcrhvvoxhglrfkutgzrewrjhuezzltkuydetbssiadcfnwawxscvllcfrbgcvtzvwdozxgizkmezigvhyackngrfhahetizpnnrmwzlgnrhvyfew",
                "fgismcxvchcvrbmfrdrnefvrweoujstqadjofimjroejrtqiyjxdouwnbnjkhcdkioypwkzqafzsyrcxccctyagznpmxuphcdhrbusruysowlrvotzhr",
                "cntrefoawvezfyczqutooinabkoukvnokifqnurlrvkwtpvmjrazbnzcypykmnyywdplzgxtdjrzynljgnjhdilbajnmwnluqagsidlnmemltzuzndiq",
                "ottqcicbvpvnrbfzgsptxdgqdassgaiwudmylqbggxtxabzhtoasrilwidoqfyobbacorduzcqwdrvmmloffwsdgxsxcslgwoikflfgovctoafanthsp",
                "zwvyqubkihgwrrdcyjsvnljnsldntveutatlwwwefeawvfavotqcgbrznwmgurcntvbrtzyydawbgxwwqpayquzfqmnkfqyanbtharhfsegyddwvsxtk",
                "rtqhhdsotsqjtjsvbzavfjtimrdgoxsfsinzohnjzfsuokprmrmrahcozfwneptyzixnpmxqrrkicbzoumhxtjnsrkivbducltscipubgejkhjybvgaq",
                "roliatgdwafjvxndohhxnqhuzixwqyphoaqovwrryycvwpbkyihlyrhazgypgnwupoikkbdkahgywhkwpujplsrkzqbffxavokhymnjourmtywppqzgd",
                "rynsoqytqaqemaeynpohgaagzqvpretkcidqbdlrfevrezqrpeaxhbegtbxmfqwhbbzcglvlpqdvrvoibogirmomnmyvexchaelhrgsiyxdqsrauhgcz",
                "stnihodnnhvnniweprmnopfjigdqohrjcetjsyxfhutvcrztimjzdoimwnenuvwxzrisphxwdsrgmrbwfkvkbfyzscmnxkmxburqcqnflgnxxptebppe",
                "unensqcpdooekfxoykujqjgqazweqninbmctfekiuzogglvexrnqavidxehnspcveeqjkctgdjnkviquzgmbbugabpqtfsqlziwjkpsoyfavpqsqyeta",
                "zacapsvwlnhkvdvhunvvuvsjokzmrtoqvrsklpjwcqixwggsvcpqzibpudclysbtlvfxkovmhglfmsxjwpbxxdnrirfilidxeiwozrdixqplkovgdwga",
                "bvujozrzhuynfuegmhqlzfxktssxoyxsttbhuvjcrhrwcveqeubezyqtsisjhpbclemfzvjrcbpgywydqcjsczlvjdesufvhjhnlcwegztpyppbirmau",
                "nnpwqvpmamulvjwzfaffwwfnmivduvzhiofajwplklzfuxebamiwinlwvhcrebapsgpdegrprqunnzpnlzlvnxukgwckzczrkrvrxogrecetbtjovumi",
                "tguzewmdblxnesecgktmpxhqtqhonvygdsihrumuhjhmdmqlylxnkhgfxptkkttpobyfxkzguiuzukltvkggrolrdhbpcweqzcxwpyflhzkbkxwhifpb",
                "tdsxmwoosthsxeqmfvxmvkphhmortetmjllvjajcvsusxmhcigqfqfmytcpmgkbryomhqyjlqfgpsptcvjhmrvmkxdxgoaxookvfkhsaoyqinjklvrxm",
                "olwmovsevpskbqrlxjmnkewzngkiajwoutalospmkkylapxzajmknimcrwntgjhceknvcfhopfarwxsyggjvrvxitmbbwkeautvzyenplnihkcisjrpa",
                "onkhznlxxpaukvtlaialylvknddywsamhmvjzgizxitieotgyvtwiqhwvmwrgzfolbzlhhmhqhpwvicvfvsoobmjnidthijvjkgtsuaibreybitgfnwt",
                "oiddtgzcqkxavfvnzxxaodyrluxshuoyetbxbcarnztifoxeluhbzhsmbselosjunmsopugevzmaqjhdfqfexzqbtwmjrxeejytauzepassqdzuirboo",
                "cgryddhuanymlrofstxtnplrofbfiqvnynlbssxvgwjtpxzkswfgnqxbyaigsftrugunzsihqrafobrjzwpmnoploztjfpazvuowowdepgmghdpjaevn",
                "unaimvtrmttiqhgegklvsxdbaskayipsvpdhnwbzswjkfqqlabjuymvzhibhqranifwvdxxxvghbwymybxsamqbvyecovedgjzbpxamshuvfukevhyxv",
                "qaqofteaxhgjhkygmmatgwbcghaphxlyybmfwrhwaofhafnotokcmlessehzeuzeymjufqqfgxpiecxyshaeugymngnrcnvabgvgynnflcprhmpzvrep",
                "ycdlkrepgbpjhmphaemnhceqqwpopvdpahcmagbihrrqfiyhmmuvqbljzdxoyceyjgnlpotyfkrnupuhdpewssfrvehvglwsujdjxzjflasgrmpvdtrx",
                "lyogcycilacfjgqghalsafysunpxjixugndklhuxhxeqfvymxkgzrhtlwklfsiaavfkjmfgtemljhjxgvdinkbahmnogvohtvtehymceynpixmossyfc",
                "ailovawtqdomxsvxeyecltkigbbyzicbqqrosohitvwsnsstqwvbpimxjpxizcmqsdektnunirfvjzqbxlcntqmefmnfobxieduyqqnyhuvsultryygs",
                "ovwuhlzxowhtbdtrtgrdcovwzpqznytbtsxcfybuwipxniohqhksvhrwwjwlhppdhofnnjjjtyhhgxoyfaschlzguxteokhyzonmxwxrueyceoalqunx",
                "gofalzgclnakenyblwufaujgklraffaltfohgulskleqadrlzosbkbivmbvrgxfcfvllrwfbjkrjplwqbotlrdgffewnddpiycwqabtjnnueyqubgqmz",
                "tveybdoegdphilxiossefoifffgnvvnosrptwdzdiqmqdlbsdvwjjgqolxegurxmkofjrgmbzyucjvuoqsxzzoqmnwvhpstzgaiziwahwukhrgwjbvja",
                "lboaxjhmbcnjeyinulwthgczpaiqwtsjugktqtftwvdatnppymkgsnhhnpxllpvhyfboaijwdozweomcawktlrczjckuthbroehpntlqhknlbbqbzcwl",
                "wzmfdybwgequlzjysxocjdpkgfmiikvgjhlohonnudkfetdxsuzezooiwcqgplmauzpbpcrlhbrnwwkrslvuclcaqsgffufbvwekavvhyoxxnhofvjzz",
                "wbzmvhtcbzdwvkiwfffgucdhmrojcqiytjnrqgttfzrdjzbqeiwanbjzsykwqsvjbictowmwvdbeccuiktjzusynsklieguhqwahumfprgvviseulpuf",
                "juuchgmloithftozitrzzmvjebfrqbxbytdfzsqqajxffnhngaoholstmxmebjgzdleeduuegtllguamuovjcpeqpqvqcdpfqvlwriazbnkiimwcdulf",
                "jrvyisqkvfrocckummtqzgyhuwmxszceryczqvjocccfeobtawjzejjzhvwauzelzikrdvfgxjnezoxzkizpriqydmaznglmpxeutlcsxpwwfvysdxjw",
                "hzvmnxlbewpvuvrphuhglgerbclhbudivawiyijcgzzcuqtdkblyhqpkucrwyxgtxfdxnnzvoyakrtqbwbzftqqoujmsiulgzpdoefkufmewhuaeyzlr",
                "sbhmntfvosdpjjepoojtcqsjmspktbelclarhfpxzsmjbqyrgkniafumxjzqkdepqegxlxwmqjvtbwliiasifmwewvwgycvpgeotblgtwdpxbchjcath",
                "mqnknjromodustowewpczeadghoijiryaeipqbdeqiykcogikylmclrlufvepncrtmhjqkngtosxczfpzqdbduoyzkerziisupekctsxhnummbbnseqv",
                "afvbrzsqhbkesqqwklvtyrfmtiznopkqwgsnhkdrnqvigneqyamwrtkmcjzsbkjxsblznqsbgpjndpfdprcjlmvpyxhzjswbvhcjavmgkvvpmbtesvnd",
                "jkshjcgsudvsmybovnvhkqxwrsampprycmiloogktbcibfwystgekfddzfrovjozvwmjnsviuasxfrwakcewjhciptwmcmlxlxiasgimgdlluhnelsdu",
                "bfeqyacdppcaplahtkvzngmhqaoburyxycqydubukgwzrwikidlwlzfbzvdvmbtmdlnifoerwasnwazhfmdrmksngxjuyejepwmwmrojtgyqjyzomefy",
                "oamuxxrwdaauwoqiherbnqtwqsmcwsbmspjpmanrcplygbipicqxslvkfhodzrqtgbludylfqwdwanlkpehjrctxjiclzugivrcysqdioieqypanvhxn",
                "jsmvcoielomggqhyimgxxmnvbokzxjmjcyegookzcwikppixdquackxgyifxttgvrmcfaofdlnnaeyxhqukvejbetibnbkkuwozxdgcqvrszprjilvdr",
                "ggxaqbptlznhoogtvijqabsrudzgaezgkzicaxvnxiwnxdgulpknsehmjgujnwszvacvyxkvggifjqzxflmzstlbcgnpcfozfqwfqgcymkdyaevhpjgh",
                "dujfcwugdifibbqrjspxduvfyspncxxftimvegbjqirtljmucduhxpovidlmdktwsfsynvhdgazrklompitozhmjlxvqhombvgziegokgndqarcpbveb",
                "dqkqpigyyuzudychgstmfwdiqfxtddwgvjymrgkpallflqorihgqgjyyqxrtdqbyzzlqfxhiltnylcstlylrhjrzhltkbwkawxsdvzniubgffybswmmf",
                "wdhfoarrwdrubjaylngfqonxpoqlcctahafycypachxdsxddkjldzaaoqscsuxtexacbzrbdyaitxlwkwjnvjpmziouelniknkloeorepzxmkuygflep",
                "dqqlekrrzabpmodscxxrwugjqerwsvnvnditqbkrdngqbmiejhxfcdoskgocddzrhjkzkxqokzgmlqsuypzcvqufyljdqkwzvjyhgrxsqdebwyxwoyyl",
                "ouqohbsylqxgzynfrnyhqekodjmthmeyjwmqxgqixqqwqfehseqlicbnloiuaoslkhehnurmmjleppnjtdwdhytuobpqqhccogkecdspndvesjpnmmtw",
                "moqaphqhrsmhayldbesqjnueymrlymjmabmsjebaznhzlvcnbwdkmaokmixmugyximptqqtpecrpxteaqknekboylmmiukfeyuxomqgqvziusmvkyiok",
                "lfiztwhniosgirxwifndexxylujkezuqgfpzbynkmhswypsiuhnaenzqhkamlwesbvrdvgphnhdoxxytfmujzvbifdwqacibxaeugvbwdgmcekvlyrwx",
                "myitbgkbjsfiulddhgbmpnovzlgyfcxrcflgoxjzpohmamphvsvkfjfewlcbpctuhgcxdlwucgicuzlprgzyrednrhpjjkftqhsvuprwvcypblhtrgri",
                "nwwgglrrxwmnffkaudwrfvihipcaytklsityvlrsjefpjrpfxnwckgltwnvujfhbocbjnsezylohdfoaumeftqyrdtnmaupqyqcmlgnjrdtukhweubjn",
                "tjewctlfnavntxbgdopvrirbqqimrrbmbfkfavknyiatfczjsogkzxnrnvdgpessldxlakaasctxgsizjolkoabdygknmehzjekmqmmkqgixasyjjlvx",
                "nyanemcqtjpeqbqgpdrglbflvfxeqsdfrgtxuvqpfhuvlkdapugcxlovsnzihfqyljyheoxlvrgidkjvgrxgflbxycgihwguhgcnuzzsqfavrlqadoii",
                "zlfannkxlsrsztgvufpmmqigdyigmsoodwqsjapxshrtcxpxeeltwtbasligdzwgvoygqodjxvebutabamwwfxyzihilggtdvtjljpwgkbkgwkhwwdte",
                "crfkanxguslrmvcvkbewcocyymvxpqdujiekwesswejibngnokjsanrazozrgclplrbjvwbucmcdzkqowbgwozxopwfvzsnmjqvfmwzqkdtjolzkmgjd",
                "hirxgyufqhtbyoimmhdwnygdmfpanydviwupuowmyqoyewmtgppvqxycfpcuqgryclnzcknccbagambietduqdyxucskijlnxaobkbdmffvhryrxrwti",
                "bthvwziglttitjjgnoustrbmqskhofrpzzmvaublpxvliervunpnfqaxkmgararszenbarnqqibypuwjhlxoezlqlureuixvokwpdlftuiulcqwlbvah",
                "unyhhrmdzjyqvvfzimucuopyemjijlrezpligzmiikyehffsrzunomnuawejkwnjlbtuafcjscpbhutytqnjcagcykliibtwenqeuupmwgqfajfwbshf",
                "unhsavdiywgclwigsauqgkvjwahxsqdmgmhgjkqjixluvwaoyweehcpfcyevphjvwqdhatrjsefqaheydkfmmwrpvwmkfxfboijqdcbwggmhpshtemft",
                "jzkevyqcvxglfrektfizowidqqyveeopdavaylctiihpzlassiugfcmvsksxqiovikxivaegklvmwvgogaxndlkxxdwonllwvjeqjiwvvuhrroixohkt",
                "svrraphnatlvcsoncmkygsryizxyiiscfluhabwbwiyyaoncbyajsujavhyersiydcfggbjcjhdlwqqzqsiimskizjosdwqjzvphyyjkhovfhlexepiq",
                "jsaidoahlsqmnhtlfevovtuceabkpjdycfifukohcetrlofsucjrvftcfvmxerxixiqtueazlvqylvthaczvjsxqpmpwfngcxwxrdxsqulofijninmew",
                "gdnwpcuvrazozxicwcsrniwwslefxicgmredtyalycbzblbxovqbenxwacdymfgawkesigdiigijslhihzjnmjlpnonzwvcufgmporzxyhgsvpaeplrd",
                "uesjshlqcnljvxyjrygrhplegnixybdvfveafrqjebtzbtlurtlbiwfrjoojrrexplxucpfjryiustolpzoxxuoikfrdwyanlzhppnyinjchesvttjrq",
                "fhyrorvnpxaaziqoxqymzcweurxncqfkadbouybmwcovmellxjzwlvchmaurszbuecjadmmbqdyejjrgurdhmfobhkscjvwpzhrcugdmjbrsmizgbenq",
                "ldrvnlxwgvnhdfkzlpluteofpnoqrdgdhzaumxtuugcxnoyadkwyqlefyuysxgxegxbuwupqcrqqfoqkapjrapyajwuidrplqqfmkwfmpvewlxhmmsdm",
                "hbosyjadcpqtfxhruoejjkgvhphthmhqnyinhisjaiehgmzcaflmptjxissrechtapjjabscmzjslkwnphbhdkgneyfkcoeeenngqikchtwseshvcjcf",
                "viuajzkloqqufdcwlmauhxonrwjvhncewxefyrsojikpomnbanwkmkxgiibrwewubabbttqdeauunhvpwtzjgzpqhsifwezzgabcwrfatzuiiryenznt",
                "yejiztnvzpxgraintppmqlvyfvesusnvywdxssvrhuzbujqpygbqtyqytvqqpflpconwiknqgnrawjpxpsplrgjmdccshnhldwhmixeomxqkghjyazjt",
                "hsfkwkcgxlrdibpqavhmsxyyfiwfjhaqafayreeppyuxzlqbgxpyunybxxigeiwgqyfhclyujsrkdjllialdomgljpupxswnrdxvqvpaqjkvswhbwugm",
                "goapduhbmfqfipdansadblawjjzhehukvwczqjceoumykpyxhbclocjxmigqpcckyglqpnvfkjfuygthhvuxxdullabcdgpdmcuesrlcarwyzphimcfj",
                "hbvvdyxieomtrgxjxknzdjzcagkokrxssunwtmezdquuytfvesuhdtmfcytmqsgkptgkillldghczozfiwpnrbutbpirhocwkkiuxufbaofbcehkcyzu",
                "ztpcizurqyqaiywgsdjsrowvuffzdgtezkgjkcaacqclrytjbeesuapohunkciqbtymfbmfdfjqwhlhkrlelntaupperawuvvgayuhdzquxzhflzqpkg",
                "kmazehsedmbaubyqkcscypbhwogpdtvnhvolcgriusiqvhgflyhjokqkyzbduwsbsgpwogeibpawyhejfnsvakialjefgyhahwwvedgfsgespkbvzvqz",
                "faatkgysgfsndqlkvtrpbxhrhiohdeilhkersejzmdoptbzrutgwqopyydhejrpqevhwzsxlvodrpeimxqiqexqdczhlqycuvjtwesizgnsytaktrujx",
                "tzcvylgolilgugdyynxhcqfvsrollxjewnzwzhnkqytmgykeljlpbskwjbhuasazgbvhjitbimnomztzigokzzgkcpfcihbqjxzsfsvqhketjztrgjdh",
                "ilrmbyplgqbppajvuendqrxzrsszbwimhzykypvggyvvagsvmfyczxbsrtrvrbhbahlaxhgfhdaijvfvcfxdfavwuornpaoskashjboqeoaolflqnjts",
                "jpqfdktvmhnwjffsitlnkldvtolgzfalwqsbcnwpvjlgrrzzkkowxtsqifyjmauitpkvcgmzsyglrfmdrbaqwujgzhqoimwdbiyerldlllwcsihjljci",
                "dlofugtctrfwagattgeeraikkpvwbxgekwlfdgjwyrsaxvtqdxwuzegjvehwbndokotnvclvtfvsaokfngamkivimdeqsjecaxrvbesxmnpodauqguct",
                "cxbrchhvrlzrkrolxgkjvayycsokosfspijuqqpjdocnhsbfalqvnovrglcudhpsqymipdtssxizpjgrwxmknjbuufqxpfrhegrvjkpbhxdyilpfkdry",
                "muugakdpsuyyapvkzkniisiqgxxqaoomjiulvxcptanwrkisuvaeqixyhuqhlfvwpphmoldjnsfecnwxlyddgabnxrwiyteqineyyihnanrdcncnlhqt",
                "iriflgpjzvbjighioqvqfovibzvohohphrwsxnewiffsnocbezumnpuqrreyhnppenjbanxivecisemyfgksxgioaomjbdyfqkgqxfaujcdbgrzlzmfw",
                "upludzeedejtormowmkfppgxgilfwqeqgrnlstqvzbrotferroxggfgmprunjyepptbhotfnwydrdjjwaidgpluhcouloadftgpjzwxxuapzkyvmgasx",
                "lmepdzdrzgxvoogpkdmggbfszcehfwfqklinklfmtejhspwevikbmrtlvzvavctfnbtaoaohgxoyomejwomihhwcgtddvylkzgkngywmxmmoyqzwgohp",
                "vfreawhvushvyukguguusiisajrgxyxtfpxflgcizjdzfogawcurlejlnculcrghifowlqemcjmhzujwwdnhjyvxdpkfisprxdniwtvycjhedrabwplg",
                "pgdsxpyfhnyesnooglmlwwpznrdlgorvuwqrloyudzyvopkxcyizuzajqdvyrovnllgybhtegtauimrnkbmfcoqusnslcqznbfldmehuyjrivkvgmjno",
                "yfjstddvtcixkvawajtatkiqugyipnzptkhmnljjptgzogyqrrqmdbdxjbiyphqkrxyeihnaavbodzhvszhvcmvlodmfmcrdzpjkwzmyunoynvthvcfx",
                "pclffzmrbdwcsfoqeaozoczdyukvwpulrfsyeerhhpmbvarbdfcrkbuivgfuyzhrhasnglxqbjrwjlzmscfcfbmbkrxirebaetnnfkdgvuefhdtahbcn",
                "cpominwbrybytrlybogzkmesqzszcwmfnctwpszhqbfjsqkvgsuqfaixccwebjlolfmdxmkpprahjmepfbfkbqhfsfktovkccwfbkrszitirfnikonwr",
                "dfxwljrbgbfjymmkdfknasghfouveqphwofhzzkfaqqacdlikvvmpetxsnuygjiczplyovernwrqbeylbvxrztouiisouaqtsdsgbyxourewvejxajqz",
                "cetkooziqrcixwpyuooohvmdzwczfsbjywvmkwxbozlnxclrtzhawwfwshxzbykzvfohclismwhjyscrtjsqfxozhlakkkkhsaownzozvxkvpmnkxhcf",
                "gsenehyorkxlmlhzkxafukblwqytxayftftzmtpffmtrxaqiyqpucsgyiethgunbzicndruidnzdorlojcilxqlfwepfyegzmlmpchzguyjkrwaaalnx",
                "byfacwfdancoypfbyejueuhvqhxsskqwivwmrbptouhpjoqjsbdyvktnuqfmcvikseylhqgyknnvdfexgjvdwqqqivcktnwltxzbnfzxvmsytyybjtef",
                "muvupahkpdyiaxjpekmzwgargysqtwxfqvcixjsmosurpgguqvvpdxgmvbcrxzwqwaatjufancrekzaawwratamrbqiyrgqojqhslpuatlednffjdxjy",
                "xxpynzyhipvrheluvguqtztigzsjydjvbbvqavzkkudubpoyxjpskibqjvbjykgblbuoxtajqedtvurudgmnrpfckimlssmgwguvcugsamnvgepjneyg",
                "tfignwrhrdnpmjmqgsigevekbttoztwtafbndsvwxkljuxbcsjiwgmhkicahyxcyedmhvjgvvterrgtlrehaqokatmirjmpnqdxnodikwpdpxxaqbiqt",
                "ycutpekaqcoihlwyqgimvneukelnodhpidizjvzbznkiaigqoodmejgonreexnvfqfebadcbtmktuqklhpxlyfbnxftwsobkwhlwkqafcmzzclmlcjwc",
                "oyrnfnjybmkxtywgoylqkmrozdadowffwzuemgcpsopmmnualftvumlvqlzgkglgfgkrmojgfyurlouwwntszenrsmyctliytvshlboqzkkmzekvtfpu",
                "jcmbpmdkzokvlecyfspgdbuehebajqwvskyjyctysgtfkxdssuyvvtbezcgjsdemncwmgrmaxhfkgjcyfcvbvwfxamgsrmhgofsxwgxwpfgwokutmswk",
                "oehpsnjjbqppvkousmsiraehkacwsbijhpazelkfebxbnlvgznqspwzzyeytfgcmyenerzkvajxquuywkoozkqziuzdbhhpflckfbwadfxtburzehodt",
                "eeeadhblpqscuehxcicjhynbpmfzalsepwetghgvxaxtfhshpvryteckqjjtuezkcefinlfnlfgsmzcbwvbpbdbtnnmhtmtvsygfllszqbrcctfyqhpr",
                "mslzfxjalcwddelopfnighmkcsitbzkpuxpbxacicyofczwtgjdnqqxtkimnjycdwtfttjdyhrflsbgzlkodcnwovkbhldmhzrcsafqjxywrzfqmreqt",
                "sohpzkwmpltocvjfcbqbzptzullnqdgkspbtbafqlahpxqwzrnbtcwuyhflzltjdknylnddydkpccmbuzepdajdkqojbjvgtiegxjjvowmqyysuxyjcz",
                "sfjjvumgptzxxhwhtrvpempegkcevgfomqzjllqcgrcebynuskjywacekglgnqwbjxkwkcyrwcxxbkrvucttcxxpeixtbvumsgielixhnueqgvlbzgwb",
                "dtsjepchkwtefdlqnizaddqjadmzjicnevykmbrxzmderowezvheaxnadcbmkebqbaanbtmcfshwifdhdkldjbgmdhzplcioeichcqkjitgryjabvohe",
                "pnruusliutwbcaigtspblxumixpdlwicjbygtjopfmqjpzpitglhegtofisqfcuqdswydmpizitqjkycrjjxrclwnfosjikochoiveswmmmvwkxpwjmn",
                "namahaurlfhnowxjaqgmcsjyfiobrcofeahmdcfojmdxibikroyvjhvoqlrjofqsiygnalbjagikjqvcftxqbtetexcuctpmtxztjcellmvueqzjmwbp",
                "rhiyemujhjvahxtsbzfmnajstidfgfuameyrqucyexynwuhyvmmjoxbhhgoqlkqaqqthkvhquhfrdmrzadkrdnaktpafbsfsiabtvklprrgxfzyidizi",
                "vzsoqvvsncmwcprxzepsvxpdxplcxkkujclczgwnlklpzenaiesebkjyzuazektppetonpdyzonyscabgthkfqigmlfqxzhmfbdssgssvgspktstobdt",
                "tnbfahxygfmlipgayyuvgpkrkdmyertygufhbdhjivxslfuldrgmgqfqvrqcklcqfhzjkguuctopyjceciqiavawmsawdcoklovwwssylhpksroubeec",
                "zganyaldcznpnllkdgkopcajvqfxujzvrzkpbvsfxhuksiwvojmdlmogdtfzcexvfhkifencnioiqndgwrlhezpjsviwbfrjpdrwjfywnoefbklxdwgh",
                "vwsnrbjuicdzfvvoavmpktulfflibrswpklinudywgzdbvtdqfscamofrbqsuiqkubskxxivehahetlvzdzzqphjqxclhuxbyrlvpvtvftcjnpgotgpl",
                "vwuovybctyerrroinhdsbidqxkesstdnsybnyesrcwkwpzeciiwlsabrmhkednrvnvkmzcfeasaqtgubotpitsahakldzeapbmddpkjrcjhvrezixoqs",
                "iqzickneqptscyxriginpskgwjovzhnizmscyigoxbizzfsjlbwcvjltsbouibeipymngsdevodwvwhhzglwpwpjafdigjsxiemqyruvfarbyzkzhvvw",
                "umfurlezuzwefivgzpbhrvipwuodrlzlxghqropmpnquvlaxdeeubomzkacbmdpljwcbmtpbhhwevybyehufxgehjijxnyixwmajgpmpykttjxtpeove",
                "wblfmwezwnwvbyejpsyodshmpbbvryzncnvolznkomfqmlzcdasguzujcygtwijaxeqidgssszkgkliolauhcpqgnzalhloepeoukjoeialtmvjzwdha",
                "uzgjaixhtlnkpehcnvgxwtskpblnfunbuvlueiezvtmmxtomoxmmqeyfgksnehqadbxjlbigwutupjiegusxbtchdxwjemmhqjqbmbkixfenoptvlnsm",
                "gwvltrvyejhwsaxgdjqaovpdmkaxyskeqhqkznkfwtbqvawykmbyjsdvddvbxhhqoxcpmmuihxydyubijeisxoqatldrskjiilywxufgsfjqanalrkfq",
                "yvquitncewlohjkgfrmxxwpzlpkecpvcnnwvhjynfjdmupubjhzgfohqgtwikrkxfjvostdaeioazjbiscqxrxpzslhdftcmexczsfzwppyoacxsenrv",
                "niuhudkbzpndopchwdfltezvgyokohibqeikivnhmamarphnsnantzjbyxnmexpuczgmwvvivhjowsdrhdeadnddkrrroinsjwegrzqphbffujwbmber",
                "ohubylupvjhfhmlbndswfxczgyavbemsohtoupdqanxibkjonblsaprhpucraqjoxefuvimvxjdytmpgpcbqruzgodzrtihtomnjxzfukivdxklommed",
                "hdlxilocvyvkkkthjyevjzaijlwxabajgngpyxtuxoghyzrjavglugtdrratuccdrlusknmhduodthovcuiwadbtvdnphpszcmtmbfvebmhwtxswrcur",
                "gynbbaslrlmwzfibmgfnspjlmdjggezmcmpfohsgsgcslmvzscokryygdhojnnxrcmzqurwoaainpdnhgbuzbuhfbvqrloipcjfwdendgvqvzddhhzgi",
                "tqpuninyyynahvzkzmnfhebijgpqfybyosubaicyirbpmaanmntvtwedevtjtwjjpflppnqxernttngfcbcwxizbeumztvjibwzqlporidkbqrissnqs",
                "vpvbmidffmpikobvgrmquzsmqagkpxeloaoakrhrfwapldmtuzjqybcqeictfhgujvwtmemuamjnryglzqbxtfpzotvvabrlyogluthwhskzqskpkooe",
                "tfdhzafbcwnamtngmufupptfhfxutlynrdwsebtiagioawxmscihrbpajmuczurqaqketemtkwimuhbnjjwcnnewzzazvsrvkcbdipzsmjhiqivzrubg",
                "hhejgfiezbbjfdonupigyppqxmpqiszsadbiilohmqssvjhpypyxepnbdfumztebwhmhsaogsjansifqxdpcsffvmzjlupprwbyqdoxyzzlthqkhvbjp",
                "gqlsswgmmvfkyfbbwazvznpjfbqdcbsltfdlclaogfaelbijbjedyvogwejbhbmajroldobltbsgfarglwlktzqsfbtochplafyftbrodjxiloqymcig",
                "dayjdtxgcotctuiovbdakakxodvbhgjkghvmatsejngfjqthrwhdyuapxwsecbokkmwmfqqqgwvrnrygngkoakdzivdmytzifxumqkdwianxroehuovw",
                "aavlxaxvtwfzwznmlqittxrklxthlqfnqcypcymyurxsskefdozwmsizpehcuoplrqctoprkgqdbdhgiwhgkzojqsssphkayactqtnacdddinjqlrwvs",
                "ngjhzdwinyipdbfwqiywldeanxlgtiaiplsopoyengusjboajpwxsczhzlpvtqdibxysmwxbettowjqiyofrqeasrqnngsvjqweeubfzwapujhckvhdn",
                "odfftusbnqnforjiuqjssambhpleyqsmuzupuotjgiquzbfvronjrzmyoafpqxbmwxcsovbwdtreuyznooyfnlgenltdiwqgwuzmrciwwzaszbgopete",
                "pzkckfiueabaucolgwheyjxxmdldhhhziudtzlpdnsfhutsdsbhqkepwjbztkjssdxneldkyvrgsnavfccxojmnuponzzhsefhjskvqgmyyzzvgdzdri",
                "qgffvshucbzhikbtfrbrqztrwzuvfngvwlcrfjnhmoqvarqflrzbsuuovojadpvzcasilipyyitzzlgkehnwbhmxxxzdpverxzzihrghzbiampnqyaoa",
                "kczhaampvrgssidbzjiylrazinsgoiialhjliwcfpiahqdirosrbjsdrfvyvfgvqqfdadfhsqjbiojaddtgnljgtegqkpmcftghylqqdarmocmtffaut",
                "jboqjecysefnmmlafbdfupvydrgltaecdsunyylrfrerfqrktvrompoqgudzxjdadapbybsduzvbromklfaywpqcjvdgejjhlyijbdpxekzvanfmsgmp" };
        char[][] board = new char[inputs.length][];

        String word = "oajgdkcokvfpdaslnmomrpgwitwdoku";

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            board[i] = input.toCharArray();
        }

        WordSearch solution = new WordSearch();
        boolean result = solution.exist(board, word);

        System.out.println(result);
    }

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            char[] rowArray = board[i];

            for (int j = 0; j < rowArray.length; j++) {
                if (search(board, i, j, word, 0, new HashMap<Integer, Boolean>())) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(char[][] board, int row, int col, String word, int start, Map<Integer, Boolean> foundMap) {
        char c = board[row][col];

        int cols = board[0].length;
        int key = row * cols + col;

        if (c == word.charAt(start)) {
            if (start == word.length() - 1) {
                return true;
            } else {
                foundMap.put(key, true);

                if (row < board.length - 1 && !visited(foundMap, row + 1, col, cols)) {
                    if (search(board, row + 1, col, word, start + 1, foundMap)) {
                        return true;
                    }
                }
                if (row > 0 && !visited(foundMap, row - 1, col, cols)) {
                    if (search(board, row - 1, col, word, start + 1, foundMap)) {
                        return true;
                    }
                }
                if (col < cols - 1 && !visited(foundMap, row, col + 1, cols)) {
                    if (search(board, row, col + 1, word, start + 1, foundMap)) {
                        return true;
                    }
                }
                if (col > 0 && !visited(foundMap, row, col - 1, cols)) {
                    if (search(board, row, col - 1, word, start + 1, foundMap)) {
                        return true;
                    }
                }
            }
        }

        foundMap.remove(key);

        return false;
    }

    private boolean visited(Map<Integer, Boolean> foundMap, int row, int col, int cols) {
        return foundMap.get(row * cols + col) != null;
    }
}
