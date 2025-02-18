// コルモゴロフ=スミルノフ分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.KolmogorovSmirnovDistribution;
class KsChartPlot implements ChartPlot {
    private static KolmogorovSmirnovDistribution ksDist = null;
    public KsChartPlot(int n) {
        ksDist = new KolmogorovSmirnovDistribution(n);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new KsPlot();

        return plot.createPlot(from, to, true);
    }
    private class KsPlot implements CreatePlot {
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

