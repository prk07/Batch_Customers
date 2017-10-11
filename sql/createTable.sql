CREATE TABLE "tb_customer_account"
  (
     "id_customer" VARCHAR2(10) NOT NULL,
     "cpf_cnpj"    VARCHAR2(14) NOT NULL,
     "nm_customer" VARCHAR2(30) NOT NULL,
     "is_active"   NUMBER(1, 0) NOT NULL,
     "vl_total"    FLOAT NOT NULL,
     CONSTRAINT "TB_CUSTOMER_ACCOUNT_PK" PRIMARY KEY ("id_customer")
  );
