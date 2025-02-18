// パレット分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.ParetoDistribution;
class ParChartPlot implements ChartPlot {
    private static ParetoDistribution parDist = null;
    public ParChartPlot(double scale, double shape) {
        parDist = new ParetoDistribution(scale, shape);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new ParPlot();

        return plot.createPlot(from, to, false);
    }
    private class ParPlot implements CreatePlot {
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

