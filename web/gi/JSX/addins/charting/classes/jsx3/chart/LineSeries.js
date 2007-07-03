/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.require("jsx3.chart.Series","jsx3.chart.PointRenderer");jsx3.Class.defineClass("jsx3.chart.LineSeries",jsx3.chart.Series,null,function(c,h){var
Dc=jsx3.vector;c.FORM_SEGMENT="segment";c.FORM_STEP="step";c.FORM_REVSTEP="reverseStep";c.FORM_HORIZONTAL="horizontal";c.FORM_VERTICAL="vertical";c.gE={segment:1,step:1,reverseStep:1,horizontal:1,vertical:1};c.V7=4;c.k8=function(n){this.series=n;};c.k8.prototype.render=function(p,d,o,r,q,n){var
E=o-p;var
Nb=r-d;var
ab=new
Dc.Group(p,d,E,Nb);var
P=this.series.ck();var
_b=new
Dc.Line(0,0,0,Math.round(Nb/2),E,Math.round(Nb/2));_b.setStroke(P);ab.appendChild(_b);var
Fb=this.series.getPointRenderer();if(Fb!=null){var
J=Math.round(E/4);var
uc=this.series.rf();var
cc=this.series.sg();var
Jc=Fb.render(J,J,E-J,Nb-J,uc,cc);ab.appendChild(Jc);}return ab;};h.init=function(a,l){this.jsxsuper(a,l);this.xField=null;this.yField=null;this.form="segment";this.interpolateValues=jsx3.Boolean.FALSE;this.pointRadius=null;this.pointRenderer=null;this.pointFill=null;this.pointStroke=null;this.pointGradient=null;this.setTooltipFunction("jsx3.chart.LineSeries.tooltip");};h.getXField=function(){return this.xField;};h.setXField=function(l){this.xField=l;};h.getYField=function(){return this.yField;};h.setYField=function(g){this.yField=g;};h.getForm=function(){return this.form;};h.setForm=function(r){if(c.gE[r]){this.form=r;}else throw new
jsx3.IllegalArgumentException("form",r);};h.getInterpolateValues=function(){return this.interpolateValues;};h.setInterpolateValues=function(j){this.interpolateValues=j;};h.getPointRadius=function(){return this.pointRadius!=null?this.pointRadius:c.V7;};h.setPointRadius=function(s){this.pointRadius=s;};h.getPointRenderer=function(){return this.Sm("pointRenderer");};h.setPointRenderer=function(a){this.Dd("pointRenderer",a);};h.getPointFill=function(){return this.pointFill;};h.setPointFill=function(r){this.pointFill=r;};h.getPointStroke=function(){return this.pointStroke;};h.setPointStroke=function(f){this.pointStroke=f;};h.getPointGradient=function(){return this.pointGradient;};h.setPointGradient=function(j){this.pointGradient=j;};h.rf=function(){var
Zb=this.pk("ne");if(Zb==null)this.kX();return this.pk("ne");};h.sg=function(){var
A=this.pk("hl");if(A==null)this.kX();return this.pk("hl");};h.kX=function(){var
nb=this.ck();var
lb=Dc.Fill.valueOf(this.getPointFill());if(lb==null&&nb!=null)lb=new
Dc.Fill(nb.getColor());if(lb!=null)lb=jsx3.chart.addGradient(lb,this.pointGradient);var
fb=Dc.Stroke.valueOf(this.getPointStroke());this.tm("ne",lb);this.tm("hl",fb);};h.updateView=function(){this.jsxsuper();var
jc=this.tf();this.shape=new
Dc.Shape(null,0,0,jc.getWidth(),jc.getHeight());this.shape.setId(this.getId()+"_line");jc.appendChild(this.shape);var
v=this.ck();this.shape.setStroke(v);this.th(this.shape);this.kX();var
x=null,cc=null;var
z=this.Tz();for(var
E=0;E<z.length;E++){var
C=z[E];if(C==null)continue;var
Db=null,ub=null,Xb=false;if(x!=null){Db=x[1];ub=x[2];Xb=cc==E-1;}this.jv(E,Xb,C[0],C[1],C[2],C[3],Db,ub);x=C;cc=E;}};h.jv=function(i,d,o,m,l,f,r,q){var
Cb=this.tf();var
Tb=this.shape;var
wc=this.getPointRenderer();if(wc!=null){var
Gb=this.getPointRadius();var
oc=this.getColorFunction();var
Ib=oc!=null?oc.call(null,o,f):this.rf();var
lb=wc.render(m-Gb,l-Gb,m+Gb,l+Gb,Ib,this.sg());lb.setId(this.getId()+"_p"+i);this.th(lb,i,o.getAttribute("jsxid"));Cb.appendChild(lb);var
db=this.getTooltipFunction();if(db!=null)lb.setToolTip(db.call(null,this,o));}var
fb=i==0||!d&&!this.interpolateValues;if(fb){Tb.dl(m,l);}else if(this.form=="segment"){Tb.pj(m,l);}else if(this.form=="horizontal"){Tb.dl(r,l).pj(m,l);}else if(this.form=="vertical"){Tb.dl(m,q).pj(m,l);}else if(this.form=="step"){Tb.pj(m,q).pj(m,l);}else if(this.form=="reverseStep"){Tb.pj(r,l).pj(m,l);}else jsx3.chart.LOG.error("bad LineSeries form: "+this.form);};h.Tz=function(){var
eb=this.pk("Xg");if(eb==null){eb=[];this.tm("Xg",eb);}return eb;};h.Co=function(d,e,p,n){this.Tz().push([d,e,p,n]);};h.Fm=function(e,f,a,m){this.Tz().push(null);};h.clear=function(){var
Gb=this.Tz();Gb.splice(0,Gb.length);};h.getXValue=function(k){if(this.xField)return jsx3.chart.asNumber(k.getAttribute(this.xField));return null;};h.getYValue=function(m){if(this.yField)return jsx3.chart.asNumber(m.getAttribute(this.yField));return null;};h.getLegendRenderer=function(){return new
c.k8(this);};c.tooltip=function(b,e){var
u=b.getXValue(e);var
pb=b.getYValue(e);return u!=null?"{"+u+","+pb+"}":pb;};h.toString=function(){return "[LineSeries '"+this.getName()+"']";};c.getVersion=function(){return jsx3.chart.sj;};});
