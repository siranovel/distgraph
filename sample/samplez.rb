require 'num4distgraph'
require_relative('mymatcher')

RSpec.describe Num4DistGraphLib do
    it '#arcsingraph' do
        expect(
            Num4DistGraphLib.arcsingraph
        ).to is_exist("arcSinGraph.jpg")
    end
    it '#betagraph' do
        expect(
            Num4DistGraphLib.betagraph(1.05, 1.05)
        ).to is_exist("betaGraph.jpg")
    end
    it '#bingraph' do
        expect(
            Num4DistGraphLib.bingraph(20, 0.4)
        ).to is_exist("binGraph.jpg")
    end
    it '#cauchygraph' do
        expect(
            Num4DistGraphLib.cauchygraph(0, 1)
        ).to is_exist("cauchyGraph.jpg")
    end
    it '#chi2graph' do
        expect(
            Num4DistGraphLib.chi2graph(5.0)
        ).to is_exist("chi2Graph.jpg")
    end
    it'#constrgraph' do
        expect(
            Num4DistGraphLib.constrgraph(5.0)
        ).to is_exist("constRGraph.jpg")
    end
    it '#expgraph' do
        expect(
            Num4DistGraphLib.expgraph(5.0)
        ).to is_exist("expGraph.jpg")
    end
    it '#fgraph' do
        expect(
            Num4DistGraphLib.fgraph(10.0, 5.0)
        ).to is_exist("fGraph.jpg")
    end
    it '#gagraph' do
        expect(
            Num4DistGraphLib.gagraph(10.0, 5.0)
        ).to is_exist("gaGraph.jpg")
    end
    it '#geraph' do
        expect(
            Num4DistGraphLib.gegraph(0.4)
        ).to is_exist("geGraph.jpg")
    end
    it '#gugraph' do
        expect(
            Num4DistGraphLib.gugraph(10.0, 5.0)
        ).to is_exist("guGraph.jpg")
    end
    it '#hygegraph' do
        expect(
            Num4DistGraphLib.hygegraph(15, 5, 10)
        ).to is_exist("hygeGraph.jpg")
    end
    it '#ksgraph' do
        expect(
            Num4DistGraphLib.ksgraph(10)
        ).to is_exist("ksGraph.jpg")
    end
    it '#lagraph' do
        expect(
            Num4DistGraphLib.lagraph(10.0, 5.0)
        ).to is_exist("laGraph.jpg")
    end
    it '#legraph' do
        expect(
            Num4DistGraphLib.legraph(10.0, 5.0)
        ).to is_exist("leGraph.jpg")
    end
    it '#loggraph' do
        expect(
            Num4DistGraphLib.loggraph(10.0, 5.0)
        ).to is_exist("logGraph.jpg")
    end
    it '#logngraph' do
        expect(
            Num4DistGraphLib.logngraph(10.0, 5.0)
        ).to is_exist("lognGraph.jpg")
    end
    it '#ngraph' do
        expect(
            Num4DistGraphLib.ngraph(10,  1.05)
        ).to is_exist("nGraph.jpg")
    end
    it '#nkgraph' do
        expect(
            Num4DistGraphLib.nkgraph(10,  5.0)
        ).to is_exist("nkGraph.jpg")
    end
    it '#pargraph' do
        expect(
            Num4DistGraphLib.pargraph(10,  5.0)
        ).to is_exist("parGraph.jpg")
    end
    it '#pasgraph' do
        expect(
            Num4DistGraphLib.pasgraph(20, 0.4)
        ).to is_exist("pasGraph.jpg")
    end
    it '#pograph' do
        expect(
            Num4DistGraphLib.pograph(0.4)
        ).to is_exist("poGraph.jpg")
    end
    it '#tglgraph' do
        expect(
            Num4DistGraphLib.tglgraph(10, 20, 13)
        ).to is_exist("tglGraph.jpg")
    end
    it '#tgraph' do
        expect(
            Num4DistGraphLib.tgraph(10)
        ).to is_exist("tGraph.jpg")
    end
    it '#uniigraph' do
        expect(
            Num4DistGraphLib.uniigraph(3, 10)
        ).to is_exist("uniiGraph.jpg")
    end
    it '#unirgraph' do
        expect(
            Num4DistGraphLib.unirgraph(1.03, 2.05)
        ).to is_exist("unirGraph.jpg")
    end
    it '#wblgraph' do
        expect(
            Num4DistGraphLib.wblgraph(5.0, 10.0)
        ).to is_exist("wblGraph.jpg")
    end
    it '#zipfgraph' do
        expect(
            Num4DistGraphLib.zipfgraph(10, 0.4)
        ).to is_exist("zipfGraph.jpg")
    end
end


