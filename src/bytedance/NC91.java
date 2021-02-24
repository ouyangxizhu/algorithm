package bytedance;

import util.IntArrUtil;

public class NC91 {
    /**
     * retrun the longest increasing subsequence
     * 最后一个，以arr[i]结尾的最长递增子序列
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int[] dp = getDp(arr);
        return generateResult(arr, dp);
    }

    public int[] getDp(int[] arr) {
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp;
    }

    /**
     * retrun the longest increasing subsequence
     * 最后一个，以arr[i]结尾的最长递增子序列
     *
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS1(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return arr;
        }
        int[] dp = getDp1(arr);
        return generateResult(arr, dp);
    }

    public int[] getDp1(int[] arr) {
        int[] dp = new int[arr.length];
        int[] ends = new int[arr.length];
        ends[0] = arr[0];
        dp[0] = 1;
        int right = 0;

        for (int i = 1; i < arr.length; i++) {
            int l = 0;
            int r = right;
            while (l <= right) {
                int m = l + ((r - l) >> 1);
                if (ends[m] < arr[i]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            right = Math.max(right, l);
            ends[l] = arr[i];
            dp[i] = l + 1;

        }
        return dp;
    }

    private int[] generateResult(int[] arr, int[] dp) {
        int index = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] > dp[index]) {
                index = i;
            }
        }
        int len = dp[index];
        int[] result = new int[len];
        result[--len] = arr[index];
        for (int i = index; i >= 0; i--) {
            if (arr[i] < arr[index] && dp[i] == dp[index] - 1) {
                result[--len] = arr[i];
                index = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = {49506168,69680825,12509291,48480857,25223382,19183828,59158379,86939717,40645996,6308877,10012993,63667893,50197187,24801729,25023038,47920500,20403356,51081751,53271648,93798698,17212977,33985688,41235650,53107971,28540590,88207258,41085783,67747947,79259171,38774038,47976443,69145317,23674167,23375819,64283405,53278302,6842944,32835306,65425302,57452938,44061263,33188353,36344809,40853306,42614674,18170661,62426275,95157030,93852465,14694594,27510732,6588658,76929617,44994473,15916331,34728593,92424819,24068421,62452242,72288496,58516068,38068970,32887138,7139725,55989211,44497486,99670615,43652169,55855016,8400743,4818109,36575316,59923999,37546251,68006009,80237095,61109920,82015485,38021784,48795556,74632998,9965861,57739193,86269790,33882927,68623665,18399472,72220645,28234019,56500908,45331825,14190203,61666988,69450522,84914849,56895970,45318684,9731080,57102758,65566000,41127251,93881179,24211530,14612193,12776968,54282870,77449039,14614543,10452592,43882497,80167247,44983066,49385171,78410318,3217127,33005856,85182575,36989391,38449809,2911542,68429766,77191995,76243538,20020672,66558032,22275577,67428579,45646061,19018102,80222016,11140706,94847351,83553167,79044071,90850947,97638757,19696162,5048263,45061895,10593784,11021585,99548228,49185118,61558041,12610798,97813429,50893959,2713568,69272475,31077457,42420740,59173742,93617193,91864670,52983094,37514765,68354281,85020387,77986223,75058335,96845131,81350492,29429045,77600838,41262844,45486388,80954883,32599496,702276,4556193,34582951,19682454,83378302,41782749,14076100,96274088,78270415,12807780,30525346,47770502,32686532,10202644,99867103,35679757,83579122,66953903,33798266,92395268,92157568,68632614,92870081,60089710,17259480,39140199,10741134,72444225,41352082,84860231,12379452,51319632,88499194,8118188,86222124,34304236,32705905,32390605,73422752,8937703,61493948,80959554,21645368,64942393,45992623,99078241,29117293,57363337,98560912,14525441,36108065,99840919,11441667,53981978,24293858,23092771,15810554,2253962,56523514,3683121,46690666,43411460,37759479,36526929,61185980,48664844,21398956,58213327,31821774,43151096,94516599,8528388,18562957,43178072,63763585,58245740,12438747,33836914,2671741,18183263,96719621,56073726,25465675,63135092,47575769,21698069,67653832,67899084,68311636,18339025,84827347,39698594,95231417,35598230,56713082,24842426,52042989,3};
        IntArrUtil.printArr(new NC91().LIS(a));
    }
}
