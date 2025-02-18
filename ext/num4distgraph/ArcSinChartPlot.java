// 逆正弦分布
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.data.xy.XYSeries;
class ArcSinChartPlot implements ChartPlot {
    public XYPlot createPlot(double from, double to) {
        CreatePlot plot = new ArcSinPlot();

        return plot.createPlot(from, to, true);
    }
    private class ArcSinPlot implements CreatePlot {
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

