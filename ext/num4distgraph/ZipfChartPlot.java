// ジーフ分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.ZipfDistribution;
class ZipfChartPlot implements ChartPlot {
    private static ZipfDistribution zipfDist = null;
    public ZipfChartPlot(int elms, double exponent) {
        zipfDist = new ZipfDistribution(elms, exponent);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new ZipfPlot();

        return plot.createPlot(from, to, false);
    }
    private class ZipfPlot implements CreatePlot {
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

