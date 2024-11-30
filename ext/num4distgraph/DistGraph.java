import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;

import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.labels.XYToolTipGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.chart.title.TextTitle;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.commons.math3.distribution.BetaDistribution;
import org.apache.commons.math3.distribution.BinomialDistribution;
import org.apache.commons.math3.distribution.CauchyDistribution;
import org.apache.commons.math3.distribution.ChiSquaredDistribution;
import org.apache.commons.math3.distribution.ConstantRealDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;
import org.apache.commons.math3.distribution.FDistribution;
import org.apache.commons.math3.distribution.GammaDistribution;
import org.apache.commons.math3.distribution.GeometricDistribution;
import org.apache.commons.math3.distribution.GumbelDistribution;
import org.apache.commons.math3.distribution.HypergeometricDistribution;
import org.apache.commons.math3.distribution.KolmogorovSmirnovDistribution;
import org.apache.commons.math3.distribution.LaplaceDistribution;
import org.apache.commons.math3.distribution.LevyDistribution;
import org.apache.commons.math3.distribution.LogisticDistribution;
import org.apache.commons.math3.distribution.LogNormalDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.NakagamiDistribution;
import org.apache.commons.math3.distribution.ParetoDistribution;
import org.apache.commons.math3.distribution.PascalDistribution;
import org.apache.commons.math3.distribution.PoissonDistribution;
import org.apache.commons.math3.distribution.TriangularDistribution;
import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.distribution.UniformIntegerDistribution;
import org.apache.commons.math3.distribution.UniformRealDistribution;
import org.apache.commons.math3.distribution.WeibullDistribution;
import org.apache.commons.math3.distribution.ZipfDistribution;
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
    public static void ksGraph(int n) {
        String subTitle = String.format("(n=%d)", n);
        ChartPlot plot = new KsChartPlot(n);
        JFreeChart chart = 
            plot.createChart("コルモゴロフ=スミルノフ分布のグラフ", 0, 1.0);

        chart.addSubtitle(new TextTitle(subTitle));
        plot.writeJPEG("ksGraph.jpg", chart, 800, 500);        
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
    private interface ChartPlot {
        /* メゾット */
        XYPlot createPlot(double from, double to);
        default JFreeChart createChart(String title, double from, double to) {
            XYPlot plot = createPlot(from, to);
            ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
            JFreeChart chart = new JFreeChart(title, plot);

            ChartUtils.applyCurrentTheme(chart);
            return chart;
        }
        default void writeJPEG(String fname, JFreeChart chart, int width, int height) {
            File file = new File(fname);
            try {
                ChartUtils.saveChartAsJPEG(file, chart, width, height);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private interface CreatePlot {
        /* フィールド */
        static final double DT = 0.001;
        /* メゾット */
        XYSeriesCollection createDataset0(double from, double to);
        XYSeriesCollection createDataset1(double from, double to);
        default XYPlot createPlot(double from, double to, boolean xfmt) {
      	    // Renderer
            XYItemRenderer renderer0 = new XYLineAndShapeRenderer(true, false);
            XYItemRenderer renderer1 = new XYLineAndShapeRenderer(true, false);
            XYToolTipGenerator toolTipGenerator = new StandardXYToolTipGenerator();

            renderer0.setDefaultToolTipGenerator(toolTipGenerator);
            renderer1.setDefaultToolTipGenerator(toolTipGenerator);
            // XYPlot
            XYPlot plot = new XYPlot();

            plot.setOrientation(PlotOrientation.VERTICAL);
            plot.mapDatasetToRangeAxis(0,0);
            plot.mapDatasetToRangeAxis(1,1);
	    plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
            /*--- 横軸 ---*/
            NumberAxis domainAxis = new NumberAxis("x");

            plot.setDomainAxis(domainAxis);
            domainAxis.setLowerBound(from);
            domainAxis.setUpperBound(to);
            if (true == xfmt) {
                domainAxis.setTickUnit(new NumberTickUnit(0.1));
                domainAxis.setNumberFormatOverride(new DecimalFormat("0.0#"));
            }
            /*--- 縦軸 ---*/
            NumberAxis valueAxis0 = new NumberAxis("密度");
            NumberAxis valueAxis1 = new NumberAxis("P");

            plot.setRangeAxis(0, valueAxis0);
            plot.setRenderer(0, renderer0);
            plot.setDataset(0, createDataset0(from, to));
            valueAxis0.setLowerBound(0.0);

            plot.setRangeAxis(1, valueAxis1);
            plot.setRenderer(1, renderer1);
            plot.setDataset(1, createDataset1(from, to));
            valueAxis1.setLowerBound(0.0);
            valueAxis1.setUpperBound(1.0);
            valueAxis1.setTickUnit(new NumberTickUnit(0.1));
            valueAxis1.setNumberFormatOverride(new DecimalFormat("0.0#"));
            return plot;
        }
    }
    /*********************************/
    /* Class define                  */
    /*********************************/
    // 逆正弦分布
    private static class ArcSinChartPlot implements ChartPlot {
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new ArcSinPlot();

            return plot.createPlot(from, to, true);
        }
        private static class ArcSinPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from + CreatePlot.DT; x < to; x += CreatePlot.DT) {
        	    /*
         	     * f(x) = 1/π * 1 / √{x(1-x)}
	             */
                    double f = 1.0 / Math.PI * 1.0 / Math.sqrt(x * (1.0 - x));
                    p.add(x, f);
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from + CreatePlot.DT; x < to; x += CreatePlot.DT) {
                    /*
		     * f(x) = 2/π * arcsin(√x)}
		    */
                    double f = 2.0 / Math.PI * Math.asin(Math.sqrt(x));
                    cu.add(x, f);

                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // ベータ分布
    private static class BetaChartPlot implements ChartPlot {
        private static BetaDistribution beDist = null;
        public BetaChartPlot(double alpha, double beta) {
            beDist = new BetaDistribution(alpha, beta);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new BetaPlot();

            return plot.createPlot(from, to, true);
        }
        private static class BetaPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from + CreatePlot.DT; x < to; x += CreatePlot.DT) {
                    p.add(x, beDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, beDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 二項分布
    private static class BinChartPlot implements ChartPlot {
        private static BinomialDistribution biDist = null;
        public BinChartPlot(int trials, double p) {
            biDist = new BinomialDistribution(trials, p);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new BinPlot();

            return plot.createPlot(from, to, false);
        }
        private static class BinPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(int x = (int)from; x < (int)to; x++) {
                    p.add(x, biDist.probability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(int x = (int)from; x < (int)to; x++) {
                    cu.add(x, biDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // コーシー分布
    private static class CauchyChartPlot implements ChartPlot {
        private static CauchyDistribution cauchyDist = null;
        public CauchyChartPlot(double median, double scale) {
            cauchyDist = new CauchyDistribution(median, scale);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new CauchyPlot();

            return plot.createPlot(from, to, false);
        }
        private static class CauchyPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from + CreatePlot.DT; x < to; x += CreatePlot.DT) {
                    p.add(x, cauchyDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, cauchyDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
           }
        }
    }
    // 階２乗分布
    private static class Chi2ChartPlot implements ChartPlot {
        private static ChiSquaredDistribution chi2Dist = null;
        public Chi2ChartPlot(double df) {
            chi2Dist = new ChiSquaredDistribution(df);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new Chi2Plot();

            return plot.createPlot(from, to, false);
        }
        private static class Chi2Plot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, chi2Dist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, chi2Dist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 実定数分布
    private static class ConstrChartPlot implements ChartPlot {
        private static ConstantRealDistribution constRDist = null;
        public ConstrChartPlot(double value) {
            constRDist = new ConstantRealDistribution(value);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new ConstrPlot();

            return plot.createPlot(from, to, false);
        }
        private static class ConstrPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeriesCollection series = new XYSeriesCollection();
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, constRDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 指数分布
    private static class ExpChartPlot implements ChartPlot {
        private static ExponentialDistribution expDist = null;
        public ExpChartPlot(double mean) {
            expDist = new ExponentialDistribution(mean);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new ExpPlot();

            return plot.createPlot(from, to, false);
        }
        private static class ExpPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, expDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, expDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // F分布
    private static class FChartPlot implements ChartPlot {
        private static FDistribution fDist = null;
        public FChartPlot(double nf, double df) {
            fDist = new FDistribution(nf, df);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new FPlot();

            return plot.createPlot(from, to, false);
        }
        private static class FPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, fDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, fDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // ガンマ分布
    private static class GaChartPlot implements ChartPlot {
        private static GammaDistribution gaDist = null;
        public GaChartPlot(double shape, double scale) {
            gaDist = new GammaDistribution(shape, scale);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new GaPlot();

            return plot.createPlot(from, to, false);
        }
        private static class GaPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, gaDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, gaDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 幾何分布
    private static class GeChartPlot implements ChartPlot {
        private static GeometricDistribution geDist = null;
        public GeChartPlot(double p) {
            geDist = new GeometricDistribution(p);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new GePlot();

            return plot.createPlot(from, to, false);
        }
        private static class GePlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(int x = (int)from; x < (int)to; x++) {
                    p.add(x, geDist.probability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(int x = (int)from; x < (int)to; x++) {
                    cu.add(x, geDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // ガンベル分布
    private static class GuChartPlot implements ChartPlot {
        private static GumbelDistribution guDist = null;
        public GuChartPlot(double mu, double beta) {
            guDist = new GumbelDistribution(mu, beta);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new GuPlot();

            return plot.createPlot(from, to, false);
        }
        private static class GuPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, guDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, guDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 超幾何分布
    private static class HygeChartPlot implements ChartPlot {
        private static HypergeometricDistribution hygeDist = null;
        public HygeChartPlot(int popsize, int nums, int smplsize) {
            hygeDist = new HypergeometricDistribution(popsize, nums, smplsize);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new HygePlot();

            return plot.createPlot(from, to, false);
        }
        private static class HygePlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(int x = (int)from; x < (int)to; x++) {
                    p.add(x, hygeDist.probability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(int x = (int)from; x < (int)to; x++) {
                    cu.add(x, hygeDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // コルモゴロフ=スミルノフ分布
    private static class KsChartPlot implements ChartPlot {
        private static KolmogorovSmirnovDistribution ksDist = null;
        public KsChartPlot(int n) {
            ksDist = new KolmogorovSmirnovDistribution(n);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new KsPlot();

            return plot.createPlot(from, to, true);
        }
        private static class KsPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeriesCollection series = new XYSeriesCollection();
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double d = from; d < to; d += CreatePlot.DT) {
                    cu.add(d, ksDist.cdf(d));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // ラプラス分布
    private static class LaChartPlot implements ChartPlot {
        private static LaplaceDistribution laDist = null;
        public LaChartPlot(double mu, double beta) {
            laDist = new LaplaceDistribution(mu, beta);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new LaPlot();

            return plot.createPlot(from, to, false);
        }
        private static class LaPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, laDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, laDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // レヴェ分布
    private static class LeChartPlot implements ChartPlot {
        private static LevyDistribution leDist = null;
        public LeChartPlot(double mu, double c) {
            leDist = new LevyDistribution(mu, c);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new LePlot();

            return plot.createPlot(from, to, false);
        }
        private static class LePlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, leDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, leDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // ロジスティック分布
    private static class LogChartPlot implements ChartPlot {
        private static LogisticDistribution logDist = null;
        public LogChartPlot(double mu, double s) {
            logDist = new LogisticDistribution(mu, s);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new LogPlot();

            return plot.createPlot(from, to, false);
        }
        private static class LogPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, logDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, logDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 対数正規分布
    private static class LognChartPlot implements ChartPlot {
        private static LogNormalDistribution lognDist = null;
        public LognChartPlot(double scale, double shape) {
            lognDist = new LogNormalDistribution(scale, shape);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new LognPlot();

            return plot.createPlot(from, to, false);
        }
        private static class LognPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, lognDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, lognDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 正規分布
    private static class NChartPlot implements ChartPlot {
        private static NormalDistribution nDist = null;
        public NChartPlot(double mean, double sd) {
            nDist = new NormalDistribution(mean, sd);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new NPlot();

            return plot.createPlot(from, to, false);
        }
        private static class NPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, nDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, nDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 仲上分布
    private static class NkChartPlot implements ChartPlot {
        private static NakagamiDistribution nkDist = null;
        public NkChartPlot(double mu, double omega) {
            nkDist = new NakagamiDistribution(mu, omega);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new NkPlot();

            return plot.createPlot(from, to, false);
        }
        private static class NkPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, nkDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, nkDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    } 
    // パレット分布
    private static class ParChartPlot implements ChartPlot {
        private static ParetoDistribution parDist = null;
        public ParChartPlot(double scale, double shape) {
            parDist = new ParetoDistribution(scale, shape);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new ParPlot();

            return plot.createPlot(from, to, false);
        }
        private static class ParPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, parDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, parDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }  
    // パスカル分布
    private static class PasChartPlot implements ChartPlot {
        private static PascalDistribution pasDist = null;
        public PasChartPlot(int r, double p) {
            pasDist = new PascalDistribution(r, p);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new PasPlot();

            return plot.createPlot(from, to, false);
        }
        private static class PasPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(int x = (int)from; x < (int)to; x++) {
                    p.add(x, pasDist.probability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(int x = (int)from; x < (int)to; x++) {
                    cu.add(x, pasDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    } 
    // ポワソン分布
    private static class PoChartPlot implements ChartPlot {
        private static PoissonDistribution poDist = null;
        public PoChartPlot(double p) {
            poDist = new PoissonDistribution(p);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new PoPlot();

            return plot.createPlot(from, to, false);
        }
        private static class PoPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(int x = (int)from; x < (int)to; x++) {
                    p.add(x, poDist.probability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(int x = (int)from; x < (int)to; x++) {
                    cu.add(x, poDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // トライアングル分布
    private static class TglChartPlot implements ChartPlot {
        private static TriangularDistribution tglDist = null;
        public TglChartPlot(double a, double b, double c) {
            tglDist = new TriangularDistribution(a, c, b);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new TglPlot();

            return plot.createPlot(from, to, false);
        }
        private static class TglPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, tglDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, tglDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }    
    }
    // T分布
    private static class TChartPlot implements ChartPlot {
        private static TDistribution tDist = null;
        public TChartPlot(double df) {
            tDist = new TDistribution(df);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new TPlot();

            return plot.createPlot(from, to, false);
        }
        private static class TPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, tDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, tDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 一様(整数)分布
    private static class UniiChartPlot implements ChartPlot {
        private static UniformIntegerDistribution uniiDist = null;
        public UniiChartPlot(int low, int up) {
            uniiDist = new UniformIntegerDistribution(low, up);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new UniiPlot();

            return plot.createPlot(from, to, false);
        }
        private static class UniiPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(int x = (int)from; x < (int)to; x++) {
                    p.add(x, uniiDist.probability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
             }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(int x = (int)from; x < (int)to; x++) {
                    cu.add(x, uniiDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // 一様(実数)分布
    private static class UnirChartPlot implements ChartPlot {
        private static UniformRealDistribution unirDist = null;
        public UnirChartPlot(double low, double up) {
            unirDist = new UniformRealDistribution(low, up);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new UnirPlot();

            return plot.createPlot(from, to, false);
        }
        private static class UnirPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, unirDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, unirDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // ワイブル分布
    private static class WblChartPlot implements ChartPlot {
        private static WeibullDistribution wblDist = null;
        public WblChartPlot(double alpha, double beta) {
            wblDist = new WeibullDistribution(alpha, beta);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new WblPlot();

            return plot.createPlot(from, to, false);
        }
        private static class WblPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    p.add(x, wblDist.density(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(double x = from; x < to; x += CreatePlot.DT) {
                    cu.add(x, wblDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
    // ジーフ分布
    private static class ZipfChartPlot implements ChartPlot {
        private static ZipfDistribution zipfDist = null;
        public ZipfChartPlot(int elms, double exponent) {
            zipfDist = new ZipfDistribution(elms, exponent);
        }
        public XYPlot createPlot(double from, double to) {
            CreatePlot plot = new ZipfPlot();

            return plot.createPlot(from, to, false);
        }
        private static class ZipfPlot implements CreatePlot {
            public XYSeriesCollection createDataset0(double from, double to) {
                XYSeries p = new XYSeries("P");

                for(int x = (int)from; x < (int)to; x++) {
                    p.add(x, zipfDist.probability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(p);
                return series;
            }
            public XYSeriesCollection createDataset1(double from, double to) {
                XYSeries cu = new XYSeries("累積");

                for(int x = (int)from; x < (int)to; x++) {
                    cu.add(x, zipfDist.cumulativeProbability(x));
                }
                XYSeriesCollection series = new XYSeriesCollection();
                series.addSeries(cu);
                return series;
            }
        }
    }
}

