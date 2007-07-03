/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.Series");jsx3.Class.defineClass("jsx3.chart.AreaSeries",jsx3.chart.Series,null,function(c,g){var
t=jsx3.vector;var
Gc=jsx3.chart;c.FORM_SEGMENT="segment";c.FORM_STEP="step";c.FORM_REVSTEP="reverseStep";c.gE={segment:1,step:1,reverseStep:1};c.V7=4;g.init=function(d,i){this.jsxsuper(d,i);this.xField=null;this.yField=null;this.minField=null;this.form="segment";this.pointRadius=null;this.pointRenderer=null;this.pointFill=null;this.pointStroke=null;this.pointGradient=null;this.setTooltipFunction("jsx3.chart.AreaSeries.tooltip");};g.getXField=function(){return this.xField;};g.setXField=function(n){this.xField=n;};g.getYField=function(){return this.yField;};g.setYField=function(i){this.yField=i;};g.getMinField=function(){return this.minField;};g.setMinField=function(s){this.minField=s;};g.getForm=function(){return this.form;};g.setForm=function(j){if(c.gE[j]){this.form=j;}else throw new
jsx3.IllegalArgumentException("form",j);};g.getPointRadius=function(){return this.pointRadius!=null?this.pointRadius:c.V7;};g.setPointRadius=function(p){this.pointRadius=p;};g.getPointRenderer=function(){return this.Sm("pointRenderer");};g.setPointRenderer=function(l){this.Dd("pointRenderer",l);};g.getPointFill=function(){return this.pointFill;};g.setPointFill=function(j){this.pointFill=j;};g.getPointStroke=function(){return this.pointStroke;};g.setPointStroke=function(l){this.pointStroke=l;};g.getPointGradient=function(){return this.pointGradient;};g.setPointGradient=function(b){this.pointGradient=b;};g.rf=function(){var
lb=this.pk("ne");if(lb==null)this.kX();return this.pk("ne");};g.sg=function(){var
Xb=this.pk("hl");if(Xb==null)this.kX();return this.pk("hl");};g.kX=function(){var
oc=this.ck();var
A=t.Fill.valueOf(this.getPointFill());if(A==null&&oc!=null)A=new
t.Fill(oc.getColor());if(A!=null)A=Gc.addGradient(A,this.pointGradient);var
Q=t.Stroke.valueOf(this.getPointStroke());this.tm("ne",A);this.tm("hl",Q);};g.getXValue=function(b){if(this.xField)return Gc.asNumber(b.getAttribute(this.xField));return null;};g.getYValue=function(e){if(this.yField)return Gc.asNumber(e.getAttribute(this.yField));return null;};g.getMinValue=function(h){if(this.minField)return Gc.asNumber(h.getAttribute(this.minField));return null;};g.Co=function(l,p,o,b){var
x=this.pk("ef");if(x==null){x=[];this.tm("ef",x);}x.push([l,p,o,b]);};g.qp=function(j,f){var
J=this.pk("Wo");if(J==null){J=[];this.tm("Wo",J);}J.push([j,f]);};g.ui=function(){var
hc=this.pk("ef");if(hc!=null)hc.splice(0,hc.length);var
sc=this.pk("Wo");if(sc!=null)sc.splice(0,sc.length);};g.updateView=function(){this.jsxsuper();var
jc=this.tf();var
ic=null,zb=null;var
V=this.Rk();if(V!=null){ic=new
t.Shape(null,0,0,jc.getWidth(),jc.getHeight());ic.setId(this.getId()+"_fill");jc.appendChild(ic);ic.setFill(V);}var
hc=this.ck();if(hc!=null){zb=new
t.Shape(null,0,0,jc.getWidth(),jc.getHeight());zb.setId(this.getId()+"_stroke");jc.appendChild(zb);zb.setStroke(hc);}this.kX();var
X=this.pk("ef");var
Z=this.pk("Wo");if(X==null||X.length==0||Z==null||Z.length==0)return;var
xc=this.getPointRenderer();var
ec=this.getPointRadius();var
Pb=this.getTooltipFunction();var
wb=this.rf();var
L=this.sg();var
Dc=this.getColorFunction();this.th(ic);for(var
Cc=0;Cc<X.length;Cc++){var
z=X[Cc][0];var
Hb=X[Cc][1];var
vc=X[Cc][2];var
ob=X[Cc][3];if(Cc==0){if(ic!=null)ic.dl(Hb,vc);if(zb!=null)zb.dl(Hb,vc);}else{var
Ub=X[Cc-1][1];var
J=X[Cc-1][2];if(this.form=="segment"){if(ic!=null)ic.pj(Hb,vc);if(zb!=null)zb.pj(Hb,vc);}else if(this.form=="step"){if(ic!=null)ic.pj(Hb,J).pj(Hb,vc);if(zb!=null)zb.pj(Hb,J).pj(Hb,vc);}else if(this.form=="reverseStep"){if(ic!=null)ic.pj(Ub,vc).pj(Hb,vc);if(zb!=null)zb.pj(Ub,vc).pj(Hb,vc);}else Gc.LOG.error("bad AreaSeries form: "+this.form);}if(xc!=null){var
nb=Dc!=null?Dc.call(null,z,ob):wb;var
yb=xc.render(Hb-ec,vc-ec,Hb+ec,vc+ec,nb,L);yb.setId(this.getId()+"_p"+Cc);this.th(yb,Cc,z.getAttribute("jsxid"));jc.appendChild(yb);if(Pb!=null)yb.setToolTip(Pb.call(null,this,z));}}for(var
Cc=Z.length-1;Cc>=0;Cc--){var
Hb=Z[Cc][0];var
vc=Z[Cc][1];if(Cc==Z.length-1){ic.pj(Hb,vc);}else{var
Ub=Z[Cc+1][0];var
J=Z[Cc+1][1];if(this.form=="segment"){ic.pj(Hb,vc);}else if(this.form=="step"){ic.pj(Ub,vc).pj(Hb,vc);}else if(this.form=="reverseStep"){ic.pj(Hb,J).pj(Hb,vc);}else Gc.LOG.error("bad AreaSeries form: "+this.form);}}ic.Bh();};c.tooltip=function(a,s){var
ac=a.getXValue(s);var
D=a.getYValue(s);var
Gb=a.getMinValue(s);var
Yb=Gb!=null?"{"+Gb+","+D+"}":D;if(ac!=null)Yb=Yb+(", x = "+ac);return Yb;};g.toString=function(){return "[AreaSeries '"+this.getName()+"']";};c.getVersion=function(){return Gc.sj;};});
