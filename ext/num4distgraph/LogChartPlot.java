// ロジスティック分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;

import org.apache.commons.math3.distribution.LogisticDistribution;
class LogChartPlot implements ChartPlot {
    private static LogisticDistribution logDist = null;
    public LogChartPlot(double mu, double s) {
        logDist = new LogisticDistribution(mu, s);
    }
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new LogPlot();

        return plot.createPlot(from, to, false);
    }
    private class LogPlot implements CreatePlot {
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

