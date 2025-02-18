// ガンマ分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.GammaDistribution;
class GaChartPlot implements ChartPlot {
    private static GammaDistribution gaDist = null;
    public GaChartPlot(double shape, double scale) {
        gaDist = new GammaDistribution(shape, scale);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new GaPlot();

        return plot.createPlot(from, to, false);
    }
    private class GaPlot implements CreatePlot {
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

