package br.ulbra.sistemadecadastro;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

public class TelaListagemUsuarios {
    MainActivity act;
    TelaPrincipal tela_principal;
    Button btanterior, btproximo, btfechar;
    TextView txtnome, txttelefone, txtendereco, txtstatus;
    EditText ednome, edendereco, edtelefone;
    int index;

    public TelaListagemUsuarios(
            MainActivity act, TelaPrincipal tela_principal) {
        this.act = act;
        this.tela_principal = tela_principal;
        index = 0;
    }

    public void CarregarTela() {
        if (act.getaRegistros().size() == 0) {
            (new AlertDialog.Builder(act)).setTitle("Aviso")
                    .setMessage("Não existe nenhum registro cadastrado")
                    .setNeutralButton("OK", null).show();
            return;
        }
        act.setContentView(R.layout.tela_listagem);
        btanterior = (Button) act.findViewById(R.id.btanterior);
        btproximo = (Button) act.findViewById(R.id.btproximo);
        btfechar = (Button) act.findViewById(R.id.btfechar);
        ednome = (EditText) act.findViewById(R.id.ednome);
        edendereco = (EditText) act.findViewById(R.id.edendereco);
        edtelefone = (EditText) act.findViewById(R.id.edtelefone);
        txtstatus = (TextView) act.findViewById(R.id.txtstatus);
        PreencheCampos(index);
        AtualizaStatus(index);
        btanterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index > 0) {
                    index--;

                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });
        btproximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (index < act.getaRegistros().size() - 1) {
                    index++;
                    PreencheCampos(index);
                    AtualizaStatus(index);
                }
            }
        });
        btfechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tela_principal.CarregarTela();
            }
        });
    }

    private void PreencheCampos(int idx) {
        ednome.setText(act.getaRegistros().get(idx).getNome());
        edendereco.setText(act.getaRegistros().get(idx).getEndereco());
        edtelefone.setText(act.getaRegistros().get(idx).getTelefone());
    }

    private void AtualizaStatus(int idx) {
        int total = act.getaRegistros().size();
        txtstatus.setText("Registros :" + (idx + 1) + "/" + total);
    }
}