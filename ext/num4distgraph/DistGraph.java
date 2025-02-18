import org.jfree.chart.JFreeChart;
import org.jfree.chart.title.TextTitle;

public class DistGraph {
    public static void arcSinGraph() {
        ChartPlot plot = new ArcSinChartPlot();
        JFreeChart chart = plot.createChart("逆正弦分布のグラフ", 0.0, 1.0);

        plot.writeJPEG("arcSinGraph.jpg", chart, 800, 500);        
    }
    public static void betaGraph(double alpha, double beta) {
        String subTitle = String.format("(alpha=%f beta=%f)", alpha, beta);;
        ChartPlot plot = new BetaChartPlot(alpha, beta);
        JFreeChart chart = plot.createChart("ベータ分布のグラフ", 0.0, 1.0);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("betaGraph.jpg", chart, 800, 500);        
    }
    public static void binGraph(int trials, double p) {
        String subTitle = String.format("(trials=%d p=%f)", trials, p);
        ChartPlot plot = new BinChartPlot(trials, p);
        JFreeChart chart = plot.createChart("二項分布のグラフ", 0, trials);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("binGraph.jpg", chart, 800, 500);        
    }
    public static void caucyGraph(double median, double scale) {
        String subTitle = String.format("(median=%f scale=%f)", median, scale);
        ChartPlot plot = new CauchyChartPlot(median, scale);
        JFreeChart chart = 
            plot.createChart("コーシー分布のグラフ", -10 + median, 10 + median);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("cauchyGraph.jpg", chart, 800, 500);        
    }
    public static void chi2Graph(double df) {
        String subTitle = String.format("(df=%f)", df);
        ChartPlot plot = new Chi2ChartPlot(df);
        JFreeChart chart = 
            plot.createChart("階２乗分布のグラフ", 0, df * 10);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("chi2Graph.jpg", chart, 800, 500);        
    }
    public static void constrGraph(double value) {
        String subTitle = String.format("(value=%f)", value);
        ChartPlot plot = new ConstrChartPlot(value);
        JFreeChart chart = 
            plot.createChart("実定数分布のグラフ", 0, value + 3);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("constRGraph.jpg", chart, 800, 500);        
    }
    public static void expGraph(double mean) {
        String subTitle = String.format("(mean=%f)", mean);
        ChartPlot plot = new ExpChartPlot(mean);
        JFreeChart chart = 
            plot.createChart("指数分布のグラフ", 0, mean * 10);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("expGraph.jpg", chart, 800, 500);        
    }
    public static void fGraph(double nf, double df) {
        String subTitle = String.format("(nf=%f df=%f)", nf, df);
        ChartPlot plot = new FChartPlot(nf, df);
        JFreeChart chart = 
            plot.createChart("F分布のグラフ", 0,15);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("fGraph.jpg", chart, 800, 500);        
    }
    public static void gaGraph(double shape, double scale) {
        String subTitle = String.format("(shape=%f scale=%f)", shape, scale);
        ChartPlot plot = new GaChartPlot(shape, scale);
        JFreeChart chart = 
            plot.createChart("ガンマ分布のグラフ", 0,150);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("gaGraph.jpg", chart, 800, 500);        
    }
    public static void geGraph(double p) {
        String subTitle = String.format("(p=%f)", p);
        ChartPlot plot = new GeChartPlot(p);
        JFreeChart chart = 
            plot.createChart("幾何分布のグラフ", -1,30);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("geGraph.jpg", chart, 800, 500);        
    }
    public static void guGraph(double mu, double beta) {
        String subTitle = String.format("(mu=%f beta=%f)", mu, beta);
        ChartPlot plot = new GuChartPlot(mu, beta);
        JFreeChart chart = 
            plot.createChart("ガンベル分布のグラフ", -3, mu * beta + 10.0);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("guGraph.jpg", chart, 800, 500);        
    }
    public static void hygeGraph(int popsize, int nums, int smplsize) {
        String subTitle = String.format("(populationSize=%d numberOfSuccesses=%d sampleSize=%d)", popsize, nums, smplsize);
        ChartPlot plot = new HygeChartPlot(popsize, nums, smplsize);
        JFreeChart chart = 
            plot.createChart("超幾何分布のグラフ", 0, popsize);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("hygeGraph.jpg", chart, 800, 500);        
    }
    public static void laGraph(double mu, double beta) {
        String subTitle = String.format("(mu=%f beta=%f)", mu, beta);
        ChartPlot plot = new LaChartPlot(mu, beta);
        JFreeChart chart = 
            plot.createChart("ラプラス分布のグラフ", -20, mu * beta);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("laGraph.jpg", chart, 800, 500);        
    }
    public static void leGraph(double mu, double c) {
        String subTitle = String.format("(mu=%f c=%f)", mu, c);
        ChartPlot plot = new LeChartPlot(mu, c);
        JFreeChart chart = 
            plot.createChart("レヴェ分布のグラフ", mu, mu * 10);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("leGraph.jpg", chart, 800, 500);        
    }
    public static void logGraph(double mu, double s) {
        String subTitle = String.format("(mu=%f s=%f)", mu, s);
        ChartPlot plot = new LogChartPlot(mu, s);
        JFreeChart chart = 
            plot.createChart("ロジスティック分布のグラフ", -(mu * s), mu * s);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("logGraph.jpg", chart, 800, 500);        
    }
    public static void lognGraph(double scale, double shape) {
        String subTitle = String.format("(scale=%f shape=%f)", scale, shape);
        ChartPlot plot = new LognChartPlot(scale, shape);
        JFreeChart chart = 
            plot.createChart("対数正規分布のグラフ", 0, (scale +  shape) * 3.0);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("lognGraph.jpg", chart, 800, 500);        
    }
    public static void nGraph(double mean, double sd) {
        String subTitle = String.format("(mean=%f sd=%f)", mean, sd);
        ChartPlot plot = new NChartPlot(mean, sd);
        JFreeChart chart = 
            plot.createChart("正規分布のグラフ", -4+mean, 4+mean);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("nGraph.jpg", chart, 800, 500);        
    }
    public static void nkGraph(double mu, double omega) {
        String subTitle = String.format("(mu=%f omega=%f)", mu, omega);
        ChartPlot plot = new NkChartPlot(mu, omega);
        JFreeChart chart = 
            plot.createChart("仲上分布のグラフ", 0.0, mu + 10);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("nkGraph.jpg", chart, 800, 500);        
    }
    public static void parGraph(double scale, double shape) {
        String subTitle = String.format("(scale=%f shape=%f)", scale, shape);
        ChartPlot plot = new ParChartPlot(scale, shape);
        JFreeChart chart = 
            plot.createChart("パレット分布のグラフ", scale, scale + 50);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("parGraph.jpg", chart, 800, 500);        
    }
    public static void pasGraph(int r, double p) {
        String subTitle = String.format("(r=%d p=%f)", r, p);
        ChartPlot plot = new PasChartPlot(r, p);
        JFreeChart chart = 
            plot.createChart("パスカル分布のグラフ", 0.0, r * 3.0);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("pasGraph.jpg", chart, 800, 500);        
    }
    public static void poGraph(double p) {
        String subTitle = String.format("(p=%f)", p);
        ChartPlot plot = new PoChartPlot(p);
        JFreeChart chart = 
            plot.createChart("ポワソン分布のグラフ", 0.0, 10.0);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("poGraph.jpg", chart, 800, 500);        
    }
    public static void tglGraph(double a, double b, double c) {
        String subTitle = String.format("(a=%f b=%f c=%f)", a, b, c);
        ChartPlot plot = new TglChartPlot(a, b, c);
        JFreeChart chart = 
            plot.createChart("トライアングル分布のグラフ", a, b);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("tglGraph.jpg", chart, 800, 500);        
    }
    public static void tGraph(double df) {
        String subTitle = String.format("(df=%f)", df);
        ChartPlot plot = new TChartPlot(df);
        JFreeChart chart = 
            plot.createChart("T分布のグラフ", -5, 5);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("tGraph.jpg", chart, 800, 500);        
    }
    public static void uniiGraph(int low, int up) {
        String subTitle = String.format("(low=%d up=%d)", low, up);
        ChartPlot plot = new UniiChartPlot(low, up);
        JFreeChart chart = 
            plot.createChart("一様(整数)分布のグラフ", low, up);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("uniiGraph.jpg", chart, 800, 500);        
    }
    public static void unirGraph(double low, double up) {
        String subTitle = String.format("(low=%f up=%f)", low, up);
        ChartPlot plot = new UnirChartPlot(low, up);
        JFreeChart chart = 
            plot.createChart("一様(実数)分布のグラフ", low, up);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("unirGraph.jpg", chart, 800, 500);        
    }
    public static void wblGraph(double alpha, double beta) {
        String subTitle = String.format("(alpha=%f beta=%f)", alpha, beta);
        ChartPlot plot = new WblChartPlot(alpha, beta);
        JFreeChart chart = 
            plot.createChart("ワイブル分布のグラフ", 0,  beta * 2);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("wblGraph.jpg", chart, 800, 500);        
    }
    public static void zipfGraph(int elms, double exponent) {
        String subTitle = String.format("(elms=%d exponent=%f)", elms, exponent);
        ChartPlot plot = new ZipfChartPlot(elms, exponent);
        JFreeChart chart = 
            plot.createChart("ジーフ分布のグラフ", 1,  elms);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("zipfGraph.jpg", chart, 800, 500);        
    }
    /*********************************/
    /* interface define              */
    /*********************************/
    /*********************************/
    /* Class define                  */
    /*********************************/
}

