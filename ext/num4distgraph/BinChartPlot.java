// 二項分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.BinomialDistribution;
class BinChartPlot implements ChartPlot {
    private static BinomialDistribution biDist = null;
    public BinChartPlot(int trials, double p) {
        biDist = new BinomialDistribution(trials, p);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new BinPlot();

        return plot.createPlot(from, to, false);
    }
    private class BinPlot implements CreatePlot {
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

