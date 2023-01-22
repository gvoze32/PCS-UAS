<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class M_supplier extends CI_Model {

    function __construct()
    {
        parent::__construct();
        $this->load->database();
    }
    
    public function getSupplier()
    {
        $query = $this->db->get('supplier');
        return $query->result_array();
    }

}