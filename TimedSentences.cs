using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace TestApp
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        private void FazOsCoisa(object sender, EventArgs e)
        {
            string teste = "Aeeeeeeeeee! #1000#Será que deu ruim?";
            string[] frases = teste.Split('#');
            List<FraseDisplay> frasesDisplay = new List<FraseDisplay>();
            richTextBox1.Text = "";
            int tempoProxFrase = 0;

            foreach (string s in frases)
            {
                int i = 0, v = 0;
                if (Int32.TryParse(s, out v))
                {
                    tempoProxFrase = v;
                }
                else
                {
                    frasesDisplay.Add(new FraseDisplay(tempoProxFrase, s));
                }
            }

            foreach (FraseDisplay f in frasesDisplay)
            {
                char[] testeBolado = f.frase.ToCharArray();
                Wait(f.tempo);
                foreach (char c in testeBolado)
                {
                    richTextBox1.Text += c;
                    Wait(50);
                }
            }
            
        }

        public class FraseDisplay
        {
            public string frase;
            public int tempo;

            public FraseDisplay(int tempo, string frase)
            {
                this.tempo = tempo;
                this.frase = frase;
            }
        }

        public void Wait(int milliseconds)
        {
            System.Windows.Forms.Timer timer1 = new System.Windows.Forms.Timer();
            if (milliseconds == 0 || milliseconds < 0) return;

            timer1.Interval = milliseconds;
            timer1.Enabled = true;
            timer1.Start();
            timer1.Tick += (s, e) =>
            {
                timer1.Enabled = false;
                timer1.Stop();
            };
            while (timer1.Enabled)
            {
                Application.DoEvents();
            }
        }
    }
}
