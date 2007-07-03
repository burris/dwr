/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.CartesianChart","jsx3.chart.LineSeries");jsx3.Class.defineClass("jsx3.chart.LineChart",jsx3.chart.CartesianChart,null,function(e,n){e.TYPE_OVERLAY="overlay";e.TYPE_STACKED="stacked";e.TYPE_STACKED100="stacked100";e.pL={overlay:1,stacked:1,stacked100:1};n.init=function(f,j,m,k,l){this.jsxsuper(f,j,m,k,l);this.type="overlay";};n.getType=function(){return this.type;};n.setType=function(s){if(e.pL[s]){this.type=s;}else throw new
jsx3.IllegalArgumentException("type",s);};n.getYRange=function(a){if(this.type=="overlay"){return this.getRangeForField(a,"getYValue");}else if(this.type=="stacked"){return this.getStackedRangeForField(a,"getYValue");}else if(this.type=="stacked100"){return this.getStacked100RangeForField(a,"getYValue");}else{jsx3.chart.LOG.error("unsupported Line Chart type: "+this.type);return null;}};n.getXRange=function(m){return this.getRangeForField(m,"getXValue");};n.updateView=function(){this.jsxsuper();this.ug();};n.ug=function(){var
T=this.wg();var
x=this.Cm();var
wc=this.bi();var
tc=this.getPrimaryXAxis();var
Y=this.getPrimaryYAxis();if(tc==null||Y==null||x.length==0||wc==null)return;if(!jsx3.chart.isValueAxis(Y)){jsx3.chart.LOG.error("bad y axis type: "+Y.getClass());return;}var
xb=null;if(this.type=="stacked100")xb=this.kk(x,"getYValue");var
v=null,gc=null;if(this.type=="stacked"||this.type=="stacked100"){v=new
Array(wc.length);gc=new
Array(wc.length);for(var
bc=0;bc<wc.length;bc++)v[bc]=gc[bc]=0;}for(var
Nb=0;Nb<x.length;Nb++){var
Ic=x[Nb];Ic.clear();for(var
bc=0;bc<wc.length;bc++){var
jb=wc[bc];var
jc=null,cc=null;var
y=Ic.getYValue(jb);if(y!=null&&(this.type=="stacked"||this.type=="stacked100")){if(y>=0)y=v[bc]=v[bc]+y;else y=gc[bc]=gc[bc]+y;if(this.type=="stacked100")y=100*(y/xb[bc]);}if(y!=null)cc=Y.getCoordinateForNoClip(y);if(jsx3.chart.isValueAxis(tc)){var
Mb=Ic.getXValue(jb);if(Mb!=null)jc=tc.getCoordinateForNoClip(Mb);}else if(jsx3.chart.isCategoryAxis(tc))jc=tc.getPointForCategory(bc);if(jc!=null&&cc!=null)Ic.Co(jb,jc,cc,bc);else Ic.Fm(jb,jc,cc,bc);}Ic.updateView();T.appendChild(Ic.tf());}};n.ad=function(){return this.type=="stacked"||this.type=="stacked100";};n.zm=function(p){return p instanceof jsx3.chart.LineSeries;};n.toString=function(){return "[LineChart '"+this.getName()+"']";};e.getVersion=function(){return jsx3.chart.sj;};});
