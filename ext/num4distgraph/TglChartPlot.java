// トライアングル分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.TriangularDistribution;
class TglChartPlot implements ChartPlot {
    private static TriangularDistribution tglDist = null;
    public TglChartPlot(double a, double b, double c) {
        tglDist = new TriangularDistribution(a, c, b);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new TglPlot();

        return plot.createPlot(from, to, false);
    }
    private class TglPlot implements CreatePlot {
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

