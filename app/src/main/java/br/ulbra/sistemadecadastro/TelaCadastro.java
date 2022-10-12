package br.ulbra.sistemadecadastro;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;

class TelaCadastroUsuario {
    MainActivity act;
    EditText edtnome, edtendereco, edttelefone;
    Button btcadastrar, btcancelar_cadastro;
    TelaPrincipal tela_principal;

    public TelaCadastroUsuario(
            MainActivity act, TelaPrincipal tela_principal) {
        this.act = act;
        this.tela_principal = tela_principal;
    }

    public void CarregarTela() {
        act.setContentView(R.layout.tela_cadastro);
        edtnome = (EditText) act.findViewById(R.id.edtNome);
        edtendereco = (EditText) act.findViewById(R.id.edtEndereco);
        edttelefone = (EditText) act.findViewById(R.id.edtTelefone);
        btcadastrar = (Button) act.findViewById(R.id.btcadastrar);

        btcancelar_cadastro = (Button)
                act.findViewById(R.id.btcancelar_cadastro);
        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new
                        AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar usuário ?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int
                                    which) {
                                String nome =
                                        edtnome.getText().toString();
                                String endereco =
                                        edtendereco.getText().toString();
                                String telefone =
                                        edttelefone.getText().toString();
                                act.getaRegistros().add(new
                                        Registro(nome, endereco, telefone));
                                act.ExibirMensagem("Cadastro efetuado com sucesso");
                                tela_principal.CarregarTela();
                            }
                        });
                dialogo.show();
            }
        });
        btcancelar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(act);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Sair do cadastro");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tela_principal.CarregarTela();
                    }
                });

                dialogo.show();
            }
        });
    }
}