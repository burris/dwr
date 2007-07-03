/*
 * Copyright (c) 2001-2007, TIBCO Software Inc.
 * Use, modification, and distribution subject to terms of license.
 */
jsx3.Class.defineClass("jsx3.chart.GridLines",jsx3.chart.ChartComponent,null,function(g,o){var
gb=jsx3.vector;var
z=gb.Stroke;o.init=function(s,d,n,p,h){this.jsxsuper(s);this.setDimensions(d,n,p,h);this.useXPrimary=jsx3.Boolean.TRUE;this.useYPrimary=jsx3.Boolean.TRUE;this.horizontalAbove=jsx3.Boolean.TRUE;this.inForeground=jsx3.Boolean.FALSE;this.borderStroke=null;this.fillV=null;this.strokeMajorV=null;this.strokeMinorV=null;this.fillH=null;this.strokeMajorH=null;this.strokeMinorH=null;};o.getUseXPrimary=function(){return this.useXPrimary;};o.setUseXPrimary=function(j){this.useXPrimary=j;};o.getUseYPrimary=function(){return this.useYPrimary;};o.setUseYPrimary=function(a){this.useYPrimary=a;};o.getHorizontalAbove=function(){return this.horizontalAbove;};o.setHorizontalAbove=function(r){this.horizontalAbove=r;};o.getInForeground=function(){return this.inForeground;};o.setInForeground=function(e){this.inForeground=e;};o.getBorderStroke=function(){return this.borderStroke;};o.setBorderStroke=function(n){this.borderStroke=n;};o.getFillV=function(){return this.fillV;};o.setFillV=function(q){this.fillV=q;};o.getStrokeMajorV=function(){return this.strokeMajorV;};o.setStrokeMajorV=function(b){this.strokeMajorV=b;};o.getStrokeMinorV=function(){return this.strokeMinorV;};o.setStrokeMinorV=function(r){this.strokeMinorV=r;};o.getFillH=function(){return this.fillH;};o.setFillH=function(s){this.fillH=s;};o.getStrokeMajorH=function(){return this.strokeMajorH;};o.setStrokeMajorH=function(f){this.strokeMajorH=f;};o.getStrokeMinorH=function(){return this.strokeMinorH;};o.setStrokeMinorH=function(r){this.strokeMinorH=r;};o.getXAxis=function(){var
mc=this.getChart();if(mc==null)return null;return this.useXPrimary?mc.getPrimaryXAxis():mc.getSecondaryXAxis();};o.getYAxis=function(){var
Vb=this.getChart();if(Vb==null)return null;return this.useYPrimary?Vb.getPrimaryYAxis():Vb.getSecondaryYAxis();};o.updateView=function(){this.jsxsuper();var
Lc=this.tf();this.th();var
V=new
gb.Group();V.setZIndex(2);Lc.appendChild(V);var
lc=new
gb.Group();lc.setZIndex(this.horizontalAbove?3:1);Lc.appendChild(lc);var
vc=this.getWidth();var
I=this.getHeight();if(this.borderStroke){var
v=z.valueOf(this.borderStroke);var
Nb=new
gb.Rectangle(0,0,vc,I);Nb.setZIndex(10);Nb.setStroke(v);Lc.appendChild(Nb);}this.wH(V,vc,I,this.getXAxis(),this.fillV,this.strokeMajorV,this.strokeMinorV,false);this.wH(lc,vc,I,this.getYAxis(),this.fillH,this.strokeMajorH,this.strokeMinorH,true);};o.wH=function(a,b,q,l,f,n,d,s){a.setDimensions(0,0,b,q);var
Ec=this.ci(f);if(l!=null){var
zb=l.yf();if(zb.length==0||Ec==1)this.h5(a,0,0,b,q,this.Zi(f,0));if(zb.length>0){if(Ec>1)this.vz(a,l,zb,f,null,s);this.ME(a,l,zb,n,null,s);this.Q8(a,l,zb,d,s);}}else this.h5(a,0,0,b,q,this.Zi(f,0));};o.vz=function(i,d,l,f,r,k){if(r==null)r=new
Array(this.ci(f));if(r.length==0)return;var
vb=i.getHeight();var
ec=i.getWidth();var
Nc=k?vb:ec;var
_b=k?ec:vb;for(var
Fc=0;Fc<=l.length;Fc++){var
B=r[Fc%r.length];if(B==null){B=r[Fc%r.length]=new
gb.RectangleGroup(0,0,ec,vb);B.setFill(this.Zi(f,Fc));i.appendChild(B);}if(Fc==l.length){if(l[Fc-1]<Nc)this.uo(B,l[Fc-1],0,Nc,_b,k);}else if(Fc==0){if(l[Fc]>0)this.uo(B,0,0,l[Fc],_b,k);}else this.uo(B,l[Fc-1],0,l[Fc],_b,k);}};o.uo=function(j,l,s,k,r,b){if(b)j.uo(s,l,r,k);else j.uo(l,s,k,r);};o.ME=function(q,c,a,i,h,j){if(h==null)h=new
Array(this.ci(i));if(h.length==0)return;var
Ac=q.getHeight();var
Bc=q.getWidth();for(var
Wb=0;Wb<a.length;Wb++){var
mb=h[Wb%h.length];if(mb==null){mb=h[Wb%h.length]=new
gb.LineGroup(0,0,Bc,Ac);mb.setStroke(this.Un(i,Wb));q.appendChild(mb);}if(j)mb.me(0,a[Wb],Bc,0);else mb.me(a[Wb],0,0,Ac);}};o.Q8=function(d,i,k,s,p){var
zc=this.ci(s);if(zc==0)return;var
lc=new
Array(zc);for(var
lb=0;lb<k.length;lb++){var
Sb=i.ff(k,lb);this.ME(d,i,Sb,s,lc,p);}};o.h5=function(p,q,i,f,b,e,c){if(e!=null){var
Ec=new
gb.Rectangle(q,i,f,b);if(c!=null)Ec.setZIndex(c);Ec.setFill(e);p.appendChild(Ec);}};o.toString=function(){return "[GridLines '"+this.getName()+"']";};o.Zi=function(j,m){if(j==null)return null;if(j instanceof Array){if(j.length>0){return gb.Fill.valueOf(j[m%j.length]);}else return null;}else return gb.Fill.valueOf(j);};o.Un=function(j,m){if(j==null)return null;if(j instanceof Array){if(j.length>0){return z.valueOf(j[m%j.length]);}else return null;}else return z.valueOf(j);};o.ci=function(j){if(j==null)return 0;return j instanceof Array?j.length:1;};o.onSetChild=function(){return false;};o.onSetParent=function(a){return jsx3.chart.Chart&&a instanceof jsx3.chart.Chart;};g.getVersion=function(){return jsx3.chart.sj;};});
