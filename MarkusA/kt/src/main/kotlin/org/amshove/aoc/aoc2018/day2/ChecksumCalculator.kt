package org.amshove.aoc.aoc2018.day2

private data class ChecksumRelevantBoxId(val containsDoubledChars: Boolean, val containsTripledChars: Boolean)

private fun String.toChecksumRelevantBoxId(): ChecksumRelevantBoxId =
    this
        .groupingBy { it }
        .eachCount()
        .let { letterToCount ->
            ChecksumRelevantBoxId(letterToCount.any { it.value == 2 }, letterToCount.any { it.value == 3 })
        }

fun calculateChecksum(boxIds: Iterable<String>) =
    boxIds
        .map { it.toChecksumRelevantBoxId() }
        .let {
            it.count { it.containsDoubledChars } * it.count { it.containsTripledChars }
        }

fun main(args: Array<String>) {
    println(calculateChecksum(INPUT))
}

val INPUT = listOf(
    "fzostwblnqkhpuzxirnevmaycq",
    "fzastwblgqkupujxirnevmaucd",
    "fzostwbxgakhpujxirnevmayci",
    "uzosmwblgqkhlujxirnevmaycd",
    "bzostwblgqkhpujxirnenfaycd",
    "fzostwblghkhpujxibneemaycd",
    "fzostwblgrkkpujxirnevqaycd",
    "fzostwblgqkhpkjxirqkvmaycd",
    "fzostwblgqdxpujbirnevmaycd",
    "fzostwblgykhfujxirfevmaycd",
    "fzostwbvgskhpujxirnevmagcd",
    "flostwblgokhpuixirnevmaycd",
    "fzostwblgzkhppjxirnevxaycd",
    "ftosuwblgqkhpujxirnevmeycd",
    "fzostkblgqkzpujxirnrvmaycd",
    "fuostwbugqkhnujxirnevmaycd",
    "frostwblgqkhpujsirneamaycd",
    "bzostwblgqkhpajxirnevmuycd",
    "fzysttbluqkhpujxirnevmaycd",
    "czostgblgqkhpujxirnevmgycd",
    "fzostwbcgqkhpujxirnevmavcr",
    "vzostwbdgqrhpujxirnevmaycd",
    "fzostwblgxkhpujxirnekmdycd",
    "fzostwblgdkspzjxirnevmaycd",
    "fzoqtwblgquhpujxirnevkaycd",
    "fzostwblgqjhfujxirnevmayzd",
    "fyostwblgtkhpujxilnevmaycd",
    "izostwblzqkhpupxirnevmaycd",
    "fzoaurblgqkhpujxirnevmaycd",
    "fzostjblgqkhpbjxirbevmaycd",
    "fzostwblgqkhpujmirngvmayca",
    "fxostwbhgqkhiujxirnevmaycd",
    "fzostwblngkhpujxirnemmaycd",
    "fzosgwblgqkhpujxirnlvqaycd",
    "bpostwblgqkhxujxirnevmaycd",
    "fzhstwblgqshpujxirnepmaycd",
    "fzootwbegqkhwujxirnevmaycd",
    "fzmstwblgqkhmujxirnevsaycd",
    "fzostwolgqkhpujxirnevmaysp",
    "foostwblgqohpujxirnevmayyd",
    "fzostwblgqkhgujxgrnevqaycd",
    "fzostwbltqkhjujxipnevmaycd",
    "fsostwblgqkhfujxirnevmayck",
    "fzostwmlgqkbpujxifnevmaycd",
    "fdostwblgqkhsujxirnecmaycd",
    "fzostwblgquhpejxiinevmaycd",
    "fzoqtwblgqkhkujxirnevmaywd",
    "fzostwblmqkmpujxirnyvmaycd",
    "fzjstwblgqkhpuyxirneomaycd",
    "fzortwblgqkhpzjxprnevmaycd",
    "fzosnwulgqkhpujxirnevpaycd",
    "fzostwbegqkvpujxirnevmaykd",
    "fzostwylzqkypujxirnevmaycd",
    "fioshwblgqehpujxirnevmaycd",
    "fzostwbliqkhoujxirnesmaycd",
    "fzostwblgqkhpujdirnelmqycd",
    "fzmstwblgqkhpujxirnnvpaycd",
    "fzostwbtgqkhcujxirnevmaycz",
    "fzostwblgqkfpujeignevmaycd",
    "fzostwbegqkhpuvxirndvmaycd",
    "fzostwblgqkcpujxmrnevmaycp",
    "fvostwblgqkhpyjxirnevmaycx",
    "fzostwblgqkhpufxirnevmzacd",
    "fzisjwblglkhpujxirnevmaycd",
    "fzosowbliqkhgujxirnevmaycd",
    "fzostwblgqkhpujxirnyvmaywl",
    "fzostwbllqnzpujxirnevmaycd",
    "fzostwblgquhpujxirneomayci",
    "fzostwblgqjepujximnevmaycd",
    "fzostwblgqrhbujxijnevmaycd",
    "fzostoblgqkhpujxirnevmoynd",
    "fzortwblgqkhpujxixnevjaycd",
    "fzostwhlgqkapujxirnevmaych",
    "fzostwblgakhpujxirnevfayct",
    "faostwblgqohpljxirnevmaycd",
    "fzostwbhgqkhpujxirnyvcaycd",
    "fjostwblgqkhpwjxirnevjaycd",
    "fzostwblgqklpuixirnevmayxd",
    "fzostwblgqkhhujxirncvmayce",
    "fzostwblzqkhpzjxkrnevmaycd",
    "fzostwblqqkbpujxirnevmcycd",
    "ffostwblxqkhpujxirnevmayxd",
    "fzostwblgqkhpbuxirnefmaycd",
    "szostiblgqkhpujxirnevoaycd",
    "fhlstwblgqkhpujxirnevmaycb",
    "fzostwblgwfhpujxirnevmayed",
    "fyostwblgqkhzujxirnevmayjd",
    "fzostwblgqkvrujxirnevmaucd",
    "fzestwblghkhpujxirnevmaycq",
    "foostwbkgqkhhujxirnevmaycd",
    "fpxstwblgqkhpujxirzevmaycd",
    "fsostwtlgqmhpujxirnevmaycd",
    "feostwelgqkhpumxirnevmaycd",
    "fzostwbvgqkhpujkirnevmayce",
    "fzmsewblgqahpujxirnevmaycd",
    "fzsstsblgkkhpujxirnevmaycd",
    "fzostwblgqkhxajxirneumaycd",
    "fzostwblmqkhpujyisnevmaycd",
    "gzostwblgqkhphjxirnevmavcd",
    "fzostwblgckgpujxirnzvmaycd",
    "qzostdblgqkhpujxirnevmaywd",
    "fzoshwblgskhpufxirnevmaycd",
    "fzosdwblgqkhpujkirnevjaycd",
    "fzvstwblgqkhpuixdrnevmaycd",
    "szostwblgqxhpujeirnevmaycd",
    "fzosvwblgtkhpujxirnevmoycd",
    "fzoscwblgqkkpujxirnevmvycd",
    "fzostsblgqnlpujxirnevmaycd",
    "fzostwblgmkhpujxlrnevjaycd",
    "fzosnwblgqklpugxirnevmaycd",
    "fcostwblgqpmpujxirnevmaycd",
    "ozostwblgbkhpujxirnevmafcd",
    "fzostwbagqkhiujxirneemaycd",
    "fzosxwblgqkhpumxirneymaycd",
    "fpostkblgqkhpujxianevmaycd",
    "fzostwblgvkhhujxirnevmaycl",
    "fzobtwtlgqkhpuwxirnevmaycd",
    "fzostwvwgqkhpujxirtevmaycd",
    "xzostwglgqkhpujtirnevmaycd",
    "fzostwblgvkhtujxirnzvmaycd",
    "jzostwblgqkhpujxirrevmvycd",
    "pzostwbagqkhpujxirnevjaycd",
    "fzostwclgqkhpujxirnhvmeycd",
    "fzostwblglkhpujxirnevmayrf",
    "fzoskwblnqkhpujxirnevmaysd",
    "fzostbblgqkhpujxirnevmjycw",
    "fzostwblggobpujxirnevmaycd",
    "fzostwblgckhpijxirnevmayxd",
    "fiostwrlgqkhpujxirnevmayck",
    "frfstwblvqkhpujxirnevmaycd",
    "fzowvwblgqkhpujsirnevmaycd",
    "fzostwblgquhgujxirnevmiycd",
    "fzoztwblgqkhpujxvrnevmaycj",
    "fzostnbtgqkhpujxixnevmaycd",
    "fzfstwblgjkrpujxirnevmaycd",
    "fzostwblpqkhpdrxirnevmaycd",
    "fivstwblgqkhpuixdrnevmaycd",
    "fzostwbpgqkhpdjxirnewmaycd",
    "fzostwblgqkhpdjxsrngvmaycd",
    "fzostwblsqkhpujxisnxvmaycd",
    "fcosvwblgqkhpujxirnevmavcd",
    "fzostwrlgekhgujxirnevmaycd",
    "fzostwblgqkhpujxindeimaycd",
    "uzostwblgqshpujxirnevmwycd",
    "fzostwzliqkhpujxirnevmaycu",
    "zzostwbtgqkhpijxirnevmaycd",
    "fzoltwblgqkhpujxinncvmaycd",
    "fzostwblgqkzpujxprnevmayhd",
    "fqostwblgqkhpujrirnevmzycd",
    "jzostwblgqkhpuzxkrnevmaycd",
    "fzostwblgqkhpuwxirszvmaycd",
    "fzostwblgqkhpxjxilnevdaycd",
    "fpmstwblgqkhpujxirnwvmaycd",
    "fzoejwblqqkhpujxirnevmaycd",
    "fzostwblgkshzujxirnevmaycd",
    "fzoatqblgqxhpujxirnevmaycd",
    "fzostwblgpkhpujiipnevmaycd",
    "fzostwblgqghpujgbrnevmaycd",
    "izosowblgqkhpujxirnejmaycd",
    "fzostwblgqthpujxjrnevmalcd",
    "fzovtwbcgqkhpujxicnevmaycd",
    "fzoatwblgqkhpujxidntvmaycd",
    "kzpstwblgqihpujxirnevmaycd",
    "fzosawnlgqkhpujxibnevmaycd",
    "fzostwblgqkhpujxarnevdajcd",
    "bzostwblgqkhpujxvrnevmrycd",
    "fzostwblgqkhpwfxirnevmazcd",
    "fzostwblgqknpujyiqnevmaycd",
    "zzostwblgqkhpujyirneqmaycd",
    "flosiwblgqihpujxirnevmaycd",
    "fzoetwblgqkhxujxirnevmeycd",
    "fznstwbugqkhpujxibnevmaycd",
    "fzbstwblgqkhpudxitnevmaycd",
    "fzostwblgqkhkujxirnexaaycd",
    "fzohthblgqkhpujxiknevmaycd",
    "fzostwblgqkhpujxirnevvayjt",
    "fzostwblggkhpujxirnrvqaycd",
    "fzostwblgqslpujxirnevmaysd",
    "aoostwblgqkhpnjxirnevmaycd",
    "fzostwblgqkhlutxirnevuaycd",
    "fxostwbugqkhpujxirnexmaycd",
    "fzoftwblgqkhpsjxirnevmaywd",
    "fzbstwblgqkhndjxirnevmaycd",
    "fzostwblgqkhpxjxipnlvmaycd",
    "fzostwbloqkhowjxirnevmaycd",
    "fzostwblgqkcpdjxirnevnaycd",
    "vzostiblgqkhpsjxirnevmaycd",
    "fzostwblgqkhazjxirnevmaycg",
    "fzostaklgqkhpujxirnevmaypd",
    "fzostwblgkkhppjxirnevpaycd",
    "izostwblgqkhpujairhevmaycd",
    "fzostwdlgqkhpuqxzrnevmaycd",
    "fzostwblgqkepujxernevmayct",
    "fzostdblgqkhpujxyrnehmaycd",
    "fzostwblgqkhsujxirnenfaycd",
    "fzostwblgqkhpujxifnevmajld",
    "fzostwblgokhpujxirxemmaycd",
    "fzastwblcqkhpujxiruevmaycd",
    "fzostwsxgqkhpuexirnevmaycd",
    "xzosxwblgqkhpujxirnetmaycd",
    "fzostwblgqkhpuexirnevmkccd",
    "fzostwblgqklpujxirnermfycd",
    "fzoetwblgqkhpujxirnehhaycd",
    "ffostwblgvkhpujxirnevmazcd",
    "fcosywblgqkhpujxirnevmaycy",
    "fzmstwblgqkhpujxdrnevmaycl",
    "fpostwblgqahpujxirnqvmaycd",
    "fzostwbmgqkhpulxornevmaycd",
    "fzostwblgqkopujxqrnevmrycd",
    "fzostwblgqkhpujxisnevmjgcd",
    "fzogtwulfqkhpujxirnevmaycd",
    "fzostwalgqkhpcjxirnevmayud",
    "fzosxwblgqkhpujxirnevmasmd",
    "fzostwblgrkowujxirnevmaycd",
    "fzostsblgqkhpujxirnevmsccd",
    "fzostwblgqkhpujxfrnnvmaocd",
    "fzostwblgqkhpujxiynsvkaycd",
    "fzosowblgqkhpwjxirnevmaecd",
    "fzosgwblgfkhpujxyrnevmaycd",
    "fzostsblgzkhpujmirnevmaycd",
    "fzostwblrqkhyuixirnevmaycd",
    "qzostwblgqkhpujxyrnevmvycd",
    "lzostwblgqkhpujxirqevmaymd",
    "fzostwblgqkbpujxirnefbaycd",
    "fzostwblgmihpujxirnevmafcd",
    "fzostmblgqkhpujxirnevmpynd",
    "fzoltwblgqkhpujlihnevmaycd",
    "fzostwblgqkhpujdirneviyycd",
    "fzgspwblgqkhpqjxirnevmaycd",
    "fzostwblgqkhtujkirnevmayld",
    "fjostwblgqkhpagxirnevmaycd",
    "fzpsthblgqkhpuzxirnevmaycd",
    "fzostwblgqkhpuhxzrneymaycd",
    "fzoftwblgqkepujxirnevcaycd",
    "fzostwblgqkbpyjxipnevmaycd",
    "fzostwqlgqkhpujxirjevmayad",
    "fzoxtwblgqkypupxirnevmaycd",
    "fzostwblgqwhpuoxiynevmaycd",
    "fzostwblgqkhpfjkirnevmavcd",
    "fzoqtwblgqkhpujxirnermaycp",
    "fzostwbngxkhpujxirnevmayqd",
    "fzostwqogqkhpcjxirnevmaycd",
    "fzostwblyqkhpujxvrnevmayzd",
    "vzostwblgqkhpujxirnevmlzcd",
    "fzostwblaqkhpujxirnevbajcd",
    "fdostwblgqkhpujxzrnevmayod",
    "fzostxbloqkhpujxirnevmcycd",
    "fzostwbcgqkhpyjxirnegmaycd",
    "fzostwblgqkhpuyxirnzrmaycd",
    "fzustwycgqkhpujxirnevmaycd"
)
