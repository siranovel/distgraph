// コーシー分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.CauchyDistribution;
class CauchyChartPlot implements ChartPlot {
    private static CauchyDistribution cauchyDist = null;
    public CauchyChartPlot(double median, double scale) {
        cauchyDist = new CauchyDistribution(median, scale);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new CauchyPlot();

        return plot.createPlot(from, to, false);
    }
    private class CauchyPlot implements CreatePlot {
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

