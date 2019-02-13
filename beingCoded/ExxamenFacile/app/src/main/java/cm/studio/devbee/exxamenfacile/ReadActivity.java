package cm.studio.devbee.exxamenfacile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

import cm.studio.devbee.exxamenfacile.Terminal_affocher.PhyloTerminal;

public class ReadActivity extends AppCompatActivity {
    PDFView mypdfListView;
    String getItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_read );
        mypdfListView=(PDFView) findViewById ( R.id.mypdfReader );
        getItem =getIntent ().getStringExtra ( "NomDuPdf" );
        getSupportActionBar ().setTitle ( getItem );
        lancerTerminal ();
    }


    public void lancerTerminal(){
        AllemandTerminal ();
        AnglaisTerminal ();
        chimieTerminal ();
        HistoireTerminal ();
        InfoTerminal ();
        LangueTerminal ();
        MathTerminal ();
        PhiloTerminal();
        PhysiqueTerminal ();
        svtTerminal ();
        litterature ();
    }


    /////////////terminal
    public void AllemandTerminal(){
        if (getItem.equals ( "bac_2009_allemand" )){
            mypdfListView.fromAsset (  "terminal/Allemand_terminal/bac_2009_allemand.pdf").load ();
        }

    }
    public void chimieTerminal(){
        if (getItem.equals ( "bac_2014_terminal_c_d" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2014_terminal_c_d.pdf").load ();
        } if (getItem.equals ( "bac_2015_terminal_c_d" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2015_terminal_c_d.pdf").load ();
        } if (getItem.equals ( "bac_2016_terminal_c_d" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2016_terminal_c_d.pdf").load ();
        }
        if (getItem.equals ( "bac_2008_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2008_serie_d_ti.pdf").load ();
        } if (getItem.equals ( "bac_2009_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2009_terminal_d.pdf").load ();
        } if (getItem.equals ( "bac_2010_terminal_d" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2010_pour_d.pdf").load ();
        } if (getItem.equals ( "bac_2011_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2011_terminal_d.pdf").load ();
        } if (getItem.equals ( "bac_2012_terminal_d" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2012_pourl_d.pdf").load ();
        } if (getItem.equals ( "bac_2013_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/chimi_terminal/bac_2013_serie_d.pdf").load ();
        }

    }
    public void AnglaisTerminal(){
        if (getItem.equals ( "bac_2009_anglais_terminal_a" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_2009_anglais_terminal_a.pdf").load ();
        } if (getItem.equals ( "bac_2009_anglais_terminal_b" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_2009_anglais_terminal_b.pdf").load ();
        } if (getItem.equals ( "bac_2009_anglais_terminal_t_c_d" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_2009_anglais_terminal_t_c_d.pdf").load ();
        } if (getItem.equals ( "bac_2014_anglais_terminal_a" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_2014_terminal_a.pdf").load ();
        } if (getItem.equals ( "bac_2015_anglais_terminal_a" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_2015_anglais_terminal_a.pdf").load ();
        } if (getItem.equals ( "bac_2016_anglais_terminal_a" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_2016_anglais_terminal_a.pdf").load ();
        } if (getItem.equals ( "bac_2017_anglais_terminal_a_c_d" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_2017_terminal_a_c_d.pdf").load ();
        } if (getItem.equals ( "bac_ 2017_serie_a" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_ bac_ 2017_serie_a.pdf").load ();
        } if (getItem.equals ( "bac_blanc_henri_2012_terminal_a4" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_blanc_henri_2012_terminal_a4.pdf").load ();
        } if (getItem.equals ( "bac_blanc_henri_2012_terminal_c_d" )){
            mypdfListView.fromAsset (  "terminal/anglais_terminal/bac_blanc_henri_2012_terminal_c_d.pdf").load ();
        }

    }

    public void HistoireTerminal(){
        if (getItem.equals ( " bac_2009_terminal_a_b" )){
            mypdfListView.fromAsset (  "terminal/histoire_terminal/bac_2009_terminal_a_b.pdf").load ();
        }
    }
    public void InfoTerminal(){
        if (getItem.equals ( "bac_2009_toute_serie" )){
            mypdfListView.fromAsset (  "terminal/informatique_terminal/bac_2009_toute_serie.pdf").load ();
        }
        if (getItem.equals ( "bac_2012_toute_serie" )){
            mypdfListView.fromAsset (  "terminal/informatique_terminal/bac_2012_toute_serie.pdf").load ();
        }
    }
    public void LangueTerminal(){
        if (getItem.equals ( "bac_2014_serie_a4" )){
            mypdfListView.fromAsset (  "terminal/langue_terminal/bac_2014_serie_a4.pdf").load ();
        }
        if (getItem.equals ( "bac_2014_serie_c_d_e_ti" )){
            mypdfListView.fromAsset (  "terminal/langue_terminal/bac_2014_serie_c_d_e_ti.pdf").load ();
        }if (getItem.equals ( "bac_2015_serie_a4" )){
            mypdfListView.fromAsset (  "terminal/langue_terminal/bac_2015_serie_a4.pdf").load ();
        }if (getItem.equals ( "bac_2015_serie_c_e_ti" )){
            mypdfListView.fromAsset (  "terminal/langue_terminal/bac_2015_serie_c_e_ti.pdf").load ();
        }if (getItem.equals ( "bac_2016_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/langue_terminal/bac_2016_serie_d_ti.pdf").load ();
        }if (getItem.equals ( "bac_2017_serie_a4" )){
            mypdfListView.fromAsset (  "terminal/langue_terminal/bac_2017_serie_a4.pdf").load ();
        }if (getItem.equals ( "bac_2017_serie_c_e" )){
            mypdfListView.fromAsset (  "terminal/langue_terminal/bac_2017_serie_c_e.pdf").load ();
        }if (getItem.equals ( "bac_blanc_henrie_2012" )){
            mypdfListView.fromAsset (  "terminal/langue_terminal/bac_blanc_henrie_2012.pdf").load ();
        }
    }
    public void MathTerminal(){
        if (getItem.equals ( "bac_2009_Math_terminal_a" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2009_Math_terminal_a.pdf").load ();
        }
        if (getItem.equals ( "bac_2009_Math_terminal_b" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2009_Math_terminal_b.pdf").load ();
        }if (getItem.equals ( "bac_2009_math_terminal_d" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2009_math_terminal_d.pdf").load ();
        }if (getItem.equals ( "bac_2009_math_terminal_c" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2009_maths_terminal_c.pdf").load ();
        }if (getItem.equals ( "bac_2014_terminal_a" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2014_terminal_a.pdf").load ();
        }if (getItem.equals ( "bac_2014_terminal_d_ti" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2014_terminal_d_ti.pdf").load ();
        }if (getItem.equals ( "bac_2015_terminal_a" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2015_terminal_a.pdf").load ();
        }if (getItem.equals ( "bac_2015_terminal_d_ti" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2015_terminal_d_ti.pdf").load ();
        }if (getItem.equals ( "bac_2016_terminal_d_ti" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2016_terminal_d_ti.pdf").load ();
        }if (getItem.equals ( "bac_2017_terminal_a" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2017_terminal_a.pdf").load ();
        }if (getItem.equals ( "bac_2017_terminal_c_e" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2017_terminal_c_e.pdf").load ();
        }if (getItem.equals ( "bac_2017_terminal_d_ti" )){
            mypdfListView.fromAsset (  "terminal/math_terminal/bac_2017_terminal_d_ti.pdf").load ();
        }
    }
    public void PhiloTerminal(){
        if (getItem.equals ( "bac_2009_terminal_a4" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2009_terminal_a4.pdf").load ();
        }
        if (getItem.equals ( "bac_2009_terminal_b" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2009_terminal_b.pdf").load ();
        }if (getItem.equals ( "bac_2014_serie_a" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2014_serie_a.pdf").load ();
        }if (getItem.equals ( "bac_2014_terminal_c_e" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2014_terminal_c_e.pdf").load ();
        }if (getItem.equals ( "bac_2015_serie_a" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2015_serie_a.pdf").load ();
        }if (getItem.equals ( "bac_2015_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2015_serie_d_ti.pdf").load ();
        }if (getItem.equals ( "bac_2016_terminal_c_e" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2016_terminal_c_e.pdf").load ();
        }if (getItem.equals ( "bac_2017_serie_a" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2017_serie_a.pdf").load ();
        }if (getItem.equals ( "bac_2017_serie_d" )){
            mypdfListView.fromAsset (  "terminal/phylo_terminal/bac_2017_serie_d.pdf").load ();
        }
    }
    public void PhysiqueTerminal(){
        if (getItem.equals ( "bac_2014_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2004_serie_d_ti.pdf").load ();
        }
        if (getItem.equals ( "bac_2015_serie_d" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2015_serie_d.pdf").load ();
        }if (getItem.equals ( "bac_2016_serie_d" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2016_serie_d.pdf").load ();
        }if (getItem.equals ( "bac_2017_serie_c_" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2017_serie_c_.pdf").load ();
        }if (getItem.equals ( "bac_2017_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2017_serie_d_ti.pdf").load ();
        }
        /////
        if (getItem.equals ( "bac_2004_serie_d_ti" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2004_serie_d_ti.pdf").load ();
        }if (getItem.equals ( "bac_2010_terminal_d" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2010_pourl_d.pdf").load ();
        }if (getItem.equals ( "bac_2012_terminal_d" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2012_pour_d.pdf").load ();
        }if (getItem.equals ( "bac_2013_serie_d" )){
            mypdfListView.fromAsset (  "terminal/physique_terminal/bac_2013_serie_d.pdf").load ();
        }
    }

    public void svtTerminal(){
        if (getItem.equals ( "bac_2009_a" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2009_a.pdf").load ();
        }
        if (getItem.equals ( "bac_2014_terminal_d_sujet1" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2014_terminal_d_sujet1.pdf").load ();
        }if (getItem.equals ( "bac_2014_terminal_d_sujet2" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2014_terminal_d_sujet2.pdf").load ();
        }if (getItem.equals ( "bac_2015_terminal_d_sujet1" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2015_terminal_d_sujet1.pdf").load ();
        }if (getItem.equals ( "bac_2015_terminal_d_sujet2" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2015_terminal_d_sujet2.pdf").load ();
        }
        if (getItem.equals ( "bac_2016_terminal_d_sujet1" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2016_terminal_d_sujet1.pdf").load ();
        }if (getItem.equals ( "bac_2016_terminal_d_sujet2" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2016_terminal_d_sujet2.pdf").load ();
        }if (getItem.equals ( "bac_2017_serie_c" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2017_serie_c.pdf").load ();
        }if (getItem.equals ( "bac_2017_terminal_d" )){
            mypdfListView.fromAsset (  "terminal/svt_termianal/bac_2017_terminal_d.pdf").load ();
        }
    }

    public void litterature(){
        if (getItem.equals ( "bac_2014_b_a" )){
            mypdfListView.fromAsset (  "terminal/literature_terminal/bac_2014_b_a.pdf").load ();
        } if (getItem.equals ( "bac_2014_serie_c_d_e" )){
            mypdfListView.fromAsset (  "terminal/literature_terminal/bac_2014_serie_c_d_e.pdf").load ();
        } if (getItem.equals ( "bac_2015_b_a" )){
            mypdfListView.fromAsset (  "terminal/literature_terminal/bac_2015_b_a.pdf").load ();
        } if (getItem.equals ( "bac_2016_serie_a" )){
            mypdfListView.fromAsset (  "terminal/literature_terminal/bac_2016_serie_a.pdf").load ();
        } if (getItem.equals ( "bac_2017_a" )){
            mypdfListView.fromAsset (  "terminal/literature_terminal/bac_2017_a.pdf").load ();
        } if (getItem.equals ( "bac_blanc_henri_2012_terminal_a_c_d" )){
            mypdfListView.fromAsset (  "terminal/literature_terminal/bac_blanc_henri_2012_terminal_a_c_d.pdf").load ();
        }
    }






//// fin
}
